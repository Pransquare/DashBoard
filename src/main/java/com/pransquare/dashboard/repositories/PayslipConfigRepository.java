package com.pransquare.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.PayslipConfig;

import java.util.List;

@Repository
public interface PayslipConfigRepository extends JpaRepository<PayslipConfig, Long> {
    List<PayslipConfig> findByCountry(String country);
}
