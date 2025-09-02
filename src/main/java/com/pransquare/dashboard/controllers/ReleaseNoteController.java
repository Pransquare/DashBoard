package com.pransquare.dashboard.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pransquare.dashboard.entities.ReleaseNoteEntity;
import com.pransquare.dashboard.models.FileSearchRequest;
import com.pransquare.dashboard.models.ReleaseNoteRequest;
import com.pransquare.dashboard.services.ReleaseNoteService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/Pransquare/MasterConfiguration/releaseNotes")
public class ReleaseNoteController {

    @Autowired
    private ReleaseNoteService releaseNoteService;
    
//    ReleaseNoteController(ReleaseNoteService releaseNoteService){
//    	this.releaseNoteService=releaseNoteService;
//    }

//    @Autowired
//    private ReleaseNoteRepository releaseNoteRepository;

    @Value("${upload-dir}")
    private String uploadDir;

    private static final Logger logger = LoggerFactory.getLogger(ReleaseNoteController.class);

    @PostMapping(value = "/uploadReleaseNotes", consumes = "multipart/form-data")
	public ResponseEntity<Map<String, Object>> uploadReleaseNotes(@RequestParam("file") MultipartFile multipartFile,
			@ModelAttribute ReleaseNoteRequest releaseNoteRequest) {
		Map<String, Object> response = releaseNoteService.uploadFile(multipartFile, releaseNoteRequest);
		return ResponseEntity.ok().body(response);
	}

    @PostMapping("/search")
    public ResponseEntity<?> searchFiles(@RequestBody FileSearchRequest searchRequest) {
    	System.out.println(searchRequest.getFileName());
        // If releaseName is provided, fetch the file by release name
        if (searchRequest.getReleaseName() != null && !searchRequest.getReleaseName().isEmpty()) {
            Optional<ReleaseNoteEntity> fileEntity = releaseNoteService.getFileByReleaseName(searchRequest.getReleaseName());
            if (fileEntity.isPresent()) {
                return ResponseEntity.ok(new FileSystemResource(new File(fileEntity.get().getUploadedPath())));
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        // If fileName is provided, fetch the file by file name
        if (searchRequest.getFileName() != null && !searchRequest.getFileName().isEmpty()) {
            Optional<ReleaseNoteEntity> fileEntity = releaseNoteService.getFileByFileName(searchRequest.getFileName());
            if (fileEntity.isPresent()) {
                return ResponseEntity.ok(new FileSystemResource(new File(fileEntity.get().getUploadedPath())));
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        // Pagination logic if neither releaseName nor fileName is provided
        PageRequest pageRequest = PageRequest.of(searchRequest.getPage(), searchRequest.getSize());
        Page<ReleaseNoteEntity> filesPage = releaseNoteService.getAllFiles(pageRequest);
        
        if (filesPage.hasContent()) {
            return ResponseEntity.ok(filesPage.getContent());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
       return releaseNoteService.downloadFile(fileName);
    }
}

