package com.pransquare.dashboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pransquare.dashboard.entities.NationalityDocumentEntity;
import com.pransquare.dashboard.services.NationalityDocumentService;

import java.util.List;

@RestController
@RequestMapping("/Pransquare/MasterConfiguration/nationalityDocuments")
public class NationalityDocumentController {

    private final NationalityDocumentService nationalityDocumentService;

    @Autowired
    public NationalityDocumentController(NationalityDocumentService nationalityDocumentService) {
        this.nationalityDocumentService = nationalityDocumentService;
    }

    // Endpoint to find documents by countryCode
    @GetMapping("/getDocumentsByCountryCode/{countryCode}")
    public List<NationalityDocumentEntity> getDocumentsByCountryCode(@PathVariable String countryCode) {
        return nationalityDocumentService.findByCountryCode(countryCode);
    }
}
