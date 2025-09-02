package com.pransquare.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.NationalityDocumentEntity;

@Repository
public interface NationalityDocumentRepository extends JpaRepository<NationalityDocumentEntity, Integer> {
    // You can add custom query methods if needed
    List<NationalityDocumentEntity> findByCountryCode(String a);
}
