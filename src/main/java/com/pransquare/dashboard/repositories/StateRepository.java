package com.pransquare.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.State;
@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

	List<State> findByCountryId(Integer countryId);

}
