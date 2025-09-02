package com.pransquare.dashboard.controllers;

import org.springframework.web.bind.annotation.*;

import com.pransquare.dashboard.entities.PayslipConfig;
import com.pransquare.dashboard.services.PayslipConfigService;

import java.util.List;

@RestController
@RequestMapping("/Pransquare/MasterConfiguration/payslip-config")
public class PayslipConfigController {

    private final PayslipConfigService service;

    public PayslipConfigController(PayslipConfigService service) {
        this.service = service;
    }

    @GetMapping("/by-country/{country}")
    public List<PayslipConfig> getPayslipConfigsByCountry(@PathVariable String country) {
        return service.getPayslipConfigsByCountry(country);
    }
}
