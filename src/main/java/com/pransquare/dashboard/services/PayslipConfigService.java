package com.pransquare.dashboard.services;

import org.springframework.stereotype.Service;

import com.pransquare.dashboard.entities.PayslipConfig;
import com.pransquare.dashboard.repositories.PayslipConfigRepository;

import java.util.List;

@Service
public class PayslipConfigService {

    private final PayslipConfigRepository repository;

    public PayslipConfigService(PayslipConfigRepository repository) {
        this.repository = repository;
    }

    public List<PayslipConfig> getPayslipConfigsByCountry(String country) {
        return repository.findByCountry(country);
    }
}
