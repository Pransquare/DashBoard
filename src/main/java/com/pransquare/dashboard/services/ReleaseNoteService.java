package com.pransquare.dashboard.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pransquare.dashboard.entities.ReleaseNoteEntity;
import com.pransquare.dashboard.exceptions.ResourceNotFoundException;
import com.pransquare.dashboard.models.ReleaseNoteRequest;
import com.pransquare.dashboard.repositories.ReleaseNoteRepository;

@Service
public class ReleaseNoteService {


	@Value("${upload-dir}")
	private String uploadDir;

	@Autowired
	private ReleaseNoteRepository releaseNoteRepository;

	public Map<String, Object> uploadFile(MultipartFile file, ReleaseNoteRequest releaseNoteRequest) {
		Map<String, Object> returnResponse = new HashMap<String, Object>();
		if (file.isEmpty()) {
			throw new RuntimeException("File is empty");
		}

		try {
			String originalFileName = file.getOriginalFilename();
			String fileName = originalFileName != null
					? originalFileName.substring(0, originalFileName.lastIndexOf('.'))
					: originalFileName;
			Optional<ReleaseNoteEntity> releaseNoteOpt = releaseNoteRepository.findByFileName(fileName);
			if (!releaseNoteOpt.isEmpty()) {
				throw new ResourceNotFoundException("File with Filename aleady exists");
			}

			byte[] bytes = file.getBytes();
			String filePath = uploadDir + file.getOriginalFilename();
			Path path = Paths.get(filePath);
			Files.write(path, bytes);

			ReleaseNoteEntity releaseNoteEntity = new ReleaseNoteEntity();
			releaseNoteEntity.setFileName(fileName);
			releaseNoteEntity.setCreatedBy(releaseNoteRequest.getCreatedBy());
			releaseNoteEntity.setReleaseName(releaseNoteRequest.getReleaseName());
			releaseNoteEntity.setReleaseVersion(releaseNoteRequest.getReleaseVersion());
			releaseNoteEntity.setReleaseDate(releaseNoteRequest.getReleaseDate());
			releaseNoteEntity.setCreatedDate(LocalDateTime.now());
			releaseNoteEntity.setUploadedPath(filePath);
			releaseNoteEntity.setStatus("Active");

			releaseNoteRepository.save(releaseNoteEntity);

			// Add a response indicating success
			returnResponse.put("status", "success");
			returnResponse.put("message", "File uploaded and release note saved successfully");
		} catch (IOException e) {
			// Handle exception if file writing fails
			System.out.println(e.fillInStackTrace());
			throw new RuntimeException("File upload failed", e);
		}

		return returnResponse;
	}

	public Optional<ReleaseNoteEntity> getFileByReleaseName(String releaseName) {
		return releaseNoteRepository.findByReleaseName(releaseName);
	}

	public Optional<ReleaseNoteEntity> getFileByFileName(String fileName) {
		return releaseNoteRepository.findByFileNameContaining(fileName);
	}

	public Page<ReleaseNoteEntity> getAllFiles(PageRequest pageRequest) {
		return releaseNoteRepository.findAll(pageRequest);
	}

	public ResponseEntity<Resource> downloadFile(String fileName) {

		try {
			Optional<ReleaseNoteEntity> releaseNoteOpt = releaseNoteRepository.findByFileName(fileName);
			if (releaseNoteOpt.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}

			ReleaseNoteEntity releaseNote = releaseNoteOpt.get();
			String uploadedPath = releaseNote.getUploadedPath();
			System.out.println("Uploaded path: " + uploadedPath); // Debugging

			if (uploadedPath == null || uploadedPath.trim().isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			}

			Path filePath = Paths.get(uploadedPath).normalize();
			File file = filePath.toFile();
			System.out.println("File name: " + file.getName()); // Debugging

			if (!file.exists()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}

			Path uploadDirPath = Paths.get(uploadDir).normalize();
			if (!filePath.startsWith(uploadDirPath)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
			}

			Resource resource = new FileSystemResource(file);
			String mimeType = getMimeType(filePath);
			System.out.println("MIME type: " + mimeType); // Debugging

			HttpHeaders headers = new HttpHeaders();
			headers.setContentDisposition(ContentDisposition.attachment().filename(fileName).build());
			headers.setContentType(MediaType.parseMediaType(mimeType));
			headers.setContentLength(file.length());

			return ResponseEntity.ok().headers(headers).body(resource);

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage()); // Debugging
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	private String getMimeType(Path filePath) {
		String mimeType;
		try {
			mimeType = Files.probeContentType(filePath);

//			System.out.println("Detected MIME type: " + mimeType); // Debugging

			if (mimeType == null) {
				String fileName = filePath.getFileName().toString().toLowerCase();
				System.out.println("File name for MIME detection: " + fileName); // Debugging
				if (fileName.endsWith(".docx")) {
					mimeType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
				} else if (fileName.endsWith(".doc")) {
					mimeType = "application/msword";
				} else if (fileName.endsWith(".pdf")) {
					mimeType = "application/pdf";
				} else if (fileName.endsWith(".xlsx")) {
					mimeType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
				} else {
					mimeType = "application/octet-stream";
				}
			}
		} catch (IOException e) {

//			System.err.println("MIME detection error: " + e.getMessage()); // Debugging
			mimeType = "application/octet-stream";
		}
//		System.out.println("Final MIME type: " + mimeType); // Debugging
		return mimeType;
	}



}
