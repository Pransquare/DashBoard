package com.pransquare.dashboard.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    private int id;
    private String pincode;
    private int cityId;
    private String cityName;
    private int stateId;
    private String stateName;
    private int countryId;
    private String countryName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
