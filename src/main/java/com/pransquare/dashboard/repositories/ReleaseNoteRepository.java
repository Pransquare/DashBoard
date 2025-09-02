package com.pransquare.dashboard.repositories;

import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.ReleaseNoteEntity;

@Repository
public interface ReleaseNoteRepository extends JpaRepository<ReleaseNoteEntity, Integer> {
    Optional<ReleaseNoteEntity> findByReleaseName(String releaseName);

    Optional<ReleaseNoteEntity> findByFileNameContaining(String fileName);

    Page<ReleaseNoteEntity> findAll(Pageable pageable);

	Optional<ReleaseNoteEntity> findByFileName(String fileName);
}
