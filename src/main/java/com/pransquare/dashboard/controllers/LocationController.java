package com.pransquare.dashboard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pransquare.dashboard.entities.Country;
import com.pransquare.dashboard.entities.Location;
import com.pransquare.dashboard.entities.State;
import com.pransquare.dashboard.entities.Zipcode;
import com.pransquare.dashboard.services.LocationService;

@RestController
@RequestMapping(value = "/Pransquare/MasterConfiguration/location")
public class LocationController {
	
	@Autowired
	LocationService locationService;
	
	@GetMapping("/getAllCountries")
	public ResponseEntity<List<Country>> getAllLocations() {
        return locationService.getAllCountries();
    }
	
	@GetMapping("/getStateByCountryId")
	public ResponseEntity<List<State>> getStateByCountryId(@RequestParam Integer countryId) {
        return locationService.getStateByCountryId(countryId);
    }
	
	@GetMapping("/getCityByStateId")
	public ResponseEntity<List<Zipcode>> getCityByStateId(@RequestParam Integer stateId) {
        return locationService.getCityByStateId(stateId);
    }
	
	@GetMapping("/getDetailsByPincode")
    public Location getDetailsByPincode(@RequestParam String pincode) {
        return locationService.getLocationByPincode(pincode);
    }

}
