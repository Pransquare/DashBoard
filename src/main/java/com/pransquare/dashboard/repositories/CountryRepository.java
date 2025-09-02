package com.pransquare.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.Country;
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
