package com.pransquare.dashboard.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "country_code", nullable = false, unique = true, length = 2)
    private String countryCode;

    @Column(name = "country_subcode", length = 10)
    private String countrySubcode;

    @Column(name = "iso", nullable = false, unique = true, length = 3)
    private String iso;

    @Column(name = "country_name", nullable = false, length = 150)
    private String countryName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountrySubcode() {
        return countrySubcode;
    }

    public void setCountrySubcode(String countrySubcode) {
        this.countrySubcode = countrySubcode;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "Country{" +
               "id=" + id +
               ", countryCode='" + countryCode + '\'' +
               ", countrySubcode='" + countrySubcode + '\'' +
               ", iso='" + iso + '\'' +
               ", countryName='" + countryName + '\'' +
               '}';
    }
}
