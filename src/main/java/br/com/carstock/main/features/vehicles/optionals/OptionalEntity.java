package br.com.carstock.main.features.vehicles.optionals;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Table(name = "optionals")
@Entity
@Getter
@Setter
public class OptionalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "optional", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VehicleOptionalEntity> vehicles = new HashSet<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public OptionalEntity() {}

    public OptionalEntity(String name) {
        this.name = name;
    }

    public OptionalEntity(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
