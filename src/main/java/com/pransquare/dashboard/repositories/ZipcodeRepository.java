package com.pransquare.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.Zipcode;
@Repository
public interface ZipcodeRepository extends JpaRepository<Zipcode, Integer> {

	List<Zipcode> findByStateId(Integer stateId);

}
