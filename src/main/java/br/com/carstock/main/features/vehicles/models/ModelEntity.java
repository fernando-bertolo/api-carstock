package br.com.carstock.main.features.vehicles.models;

import br.com.carstock.main.features.vehicles.brands.BrandEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = "models")
@Getter
@Setter
public class ModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private BrandEntity brand;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public ModelEntity() {}

    public ModelEntity(UUID id, String name, boolean active, BrandEntity brand) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.brand = brand;
    }

    public ModelEntity(String name, boolean active, BrandEntity brand) {
        this.name = name;
        this.active = active;
        this.brand = brand;
    }
}
