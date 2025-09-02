package com.pransquare.dashboard.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pransquare.dashboard.entities.Country;
import com.pransquare.dashboard.entities.Location;
import com.pransquare.dashboard.entities.State;
import com.pransquare.dashboard.entities.Zipcode;
import com.pransquare.dashboard.repositories.CountryRepository;
import com.pransquare.dashboard.repositories.LocationRepository;
import com.pransquare.dashboard.repositories.StateRepository;
import com.pransquare.dashboard.repositories.ZipcodeRepository;

@Service
public class LocationService {

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	StateRepository stateRepository;

	@Autowired
	ZipcodeRepository zipcodeRepository;
	@Autowired
	private LocationRepository locationRepository;

	public ResponseEntity<List<Country>> getAllCountries() {

		return ResponseEntity.ok(countryRepository.findAll().stream().collect(Collectors.toList()));
	}

	public ResponseEntity<List<State>> getStateByCountryId(Integer countryId) {
		return ResponseEntity.ok(stateRepository.findByCountryId(countryId));
	}

//	public ResponseEntity<List<Zipcode>> getCityByStateId(Integer stateId) {
//		return ResponseEntity.ok(zipcodeRepository.findByStateId(stateId));
//	}

	public Location getLocationByPincode(String pincode) {
		return locationRepository.findByPincode(pincode);
	}
	
	public ResponseEntity<List<Zipcode>> getCityByStateId(Integer stateId) {
        List<Zipcode> result = zipcodeRepository.findByStateId(stateId);
        return ResponseEntity.ok(result);
    }
	
	

}
