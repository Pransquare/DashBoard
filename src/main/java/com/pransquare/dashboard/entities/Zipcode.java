package com.pransquare.dashboard.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "zipcode")
public class Zipcode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", nullable = false, length = 20)
    private String code;

    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private State state;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Zipcode{" +
               "id=" + id +
               ", code='" + code + '\'' +
               ", state=" + state +
               ", city='" + city + '\'' +
               '}';
    }
}
