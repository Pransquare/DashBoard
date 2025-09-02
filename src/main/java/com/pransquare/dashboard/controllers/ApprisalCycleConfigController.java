package com.pransquare.dashboard.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pransquare.dashboard.entities.ApprisalCycleConfig;
import com.pransquare.dashboard.services.ApprisalCycleConfigService;

@RestController
@RequestMapping("/Pransquare/MasterConfiguration/apprisal_config")
public class ApprisalCycleConfigController {

    private ApprisalCycleConfigService apprisalCycleConfigService;

    ApprisalCycleConfigController(ApprisalCycleConfigService apprisalCycleConfigService) {
        this.apprisalCycleConfigService = apprisalCycleConfigService;
    }

    @GetMapping("/getActive")
    public ResponseEntity<ApprisalCycleConfig> getActive() {
        return apprisalCycleConfigService.getActiveApprisalCycle();
    }
}
