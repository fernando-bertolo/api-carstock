package br.com.carstock.main.features.vehicles.versions;

import br.com.carstock.main.features.vehicles.models.ModelEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "versions")
@Getter
@Setter
public class VersionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    private ModelEntity model;

    private String engine;

    @Enumerated(EnumType.STRING)
    private TransmissionTypeEnum transmission;

    @Enumerated(EnumType.STRING)
    private FuelTypeEnum fuelType;

    private boolean active;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public VersionEntity() {}

    public VersionEntity(UUID id, String name, ModelEntity model, String engine,
                         TransmissionTypeEnum transmission, FuelTypeEnum fuelType, boolean active
    ) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.engine = engine;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.active = active;
    }

    public VersionEntity(
            String name, ModelEntity model, String engine,
            TransmissionTypeEnum transmission, FuelTypeEnum fuelType, boolean active
    ) {
        this.name = name;
        this.model = model;
        this.engine = engine;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.active = active;
    }
}
