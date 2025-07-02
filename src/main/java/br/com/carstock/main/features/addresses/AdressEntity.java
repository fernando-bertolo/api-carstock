package br.com.carstock.main.features.addresses;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "addresses")
public class AdressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final String street;
    private final String neighborhood;
    private final String city;
    private final String state;
    private final String country;
    private final Integer number;
    private final String zipcode;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public AdressEntity(String street, String neighborhood, String city, String state, String country, Integer number, String zipcode) {
        this.street = street;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.number = number;
        this.zipcode = zipcode;
    }

    public AdressEntity() {
        this.id = 0L;
        this.street = "";
        this.neighborhood = "";
        this.city = "";
        this.state = "";
        this.country = "";
        this.number = 0;
        this.zipcode = "";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public Integer getNumber() {
        return number;
    }

    public String getZipcode() {
        return zipcode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
