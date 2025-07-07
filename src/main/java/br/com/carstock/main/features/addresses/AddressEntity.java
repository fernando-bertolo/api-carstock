package br.com.carstock.main.features.addresses;

import br.com.carstock.main.features.branches.BranchEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "addresses")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private final String street;
    private final String neighborhood;
    private final String city;

    @Enumerated(EnumType.STRING)
    private final States state;

    @Enumerated(EnumType.STRING)
    private final Countries country;
    private final Integer number;
    private final String zipcode;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BranchEntity> branch = new HashSet<>();

    public AddressEntity(String street, String neighborhood, String city, States state, Countries country, Integer number, String zipcode) {
        this.street = street;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.number = number;
        this.zipcode = zipcode;
    }

    public AddressEntity(UUID id, String street, String neighborhood, String city, States state, Countries country, Integer number, String zipcode) {
        this.id = id;
        this.street = street;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.number = number;
        this.zipcode = zipcode;
    }

    public AddressEntity() {
        this.id = UUID.randomUUID();
        this.street = "";
        this.neighborhood = "";
        this.city = "";
        this.state = States.SP;
        this.country = Countries.BRAZIL;
        this.number = 0;
        this.zipcode = "";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public UUID getId() {
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

    public States getState() {
        return state;
    }

    public Countries getCountry() {
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
