package com.pransquare.dashboard.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pransquare.dashboard.entities.ApprisalCycleConfig;
import com.pransquare.dashboard.repositories.ApprisalCycleConfigRepo;

@Service
public class ApprisalCycleConfigService {

    private ApprisalCycleConfigRepo apprisalCycleConfigRepo;

    ApprisalCycleConfigService(ApprisalCycleConfigRepo apprisalCycleConfigRepo) {
        this.apprisalCycleConfigRepo = apprisalCycleConfigRepo;
    }

    public ResponseEntity<ApprisalCycleConfig> getActiveApprisalCycle() {
        return ResponseEntity.ok(apprisalCycleConfigRepo.findByIsActive(Boolean.TRUE));
    }
}
