package com.pransquare.dashboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pransquare.dashboard.entities.NationalityDocumentEntity;
import com.pransquare.dashboard.repositories.NationalityDocumentRepository;

import java.util.List;

@Service
public class NationalityDocumentService {

    private final NationalityDocumentRepository nationalityDocumentRepository;

    @Autowired
    public NationalityDocumentService(NationalityDocumentRepository nationalityDocumentRepository) {
        this.nationalityDocumentRepository = nationalityDocumentRepository;
    }

    // Method to find NationalityDocumentEntities by countryCode
    public List<NationalityDocumentEntity> findByCountryCode(String countryCode) {
        return nationalityDocumentRepository.findByCountryCode(countryCode);
    }
}
