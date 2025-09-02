package com.pransquare.dashboard.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    Location findByPincode(String pincode);
    
}
