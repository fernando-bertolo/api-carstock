package br.com.carstock.main.features.vehicles;

import br.com.carstock.main.features.vehicles.optionals.VehicleOptionalEntity;
import br.com.carstock.main.features.vehicles.versions.VersionEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String chassis;

    @Column(name = "manufacturer_year")
    private Integer manufacturerYear;

    @Column(name = "model_year")
    private Integer modelYear;

    @Column(name = "license_plate")
    private String licensePlate;

    private String color;

    @Column(nullable = false)
    private Integer mileage;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private StatusVehicleEnum status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "version_id", nullable = false)
    private VersionEntity version;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VehicleOptionalEntity> optionals = new HashSet<>();

    @Column(name = "entry_date", nullable = false)
    private LocalDateTime entryDate;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public VehicleEntity() {}

    public VehicleEntity(
            UUID id, String name, VersionEntity version, String chassis, String licensePlate, Integer modelYear, Integer manufacturerYear,
            String color, Integer mileage, BigDecimal price, StatusVehicleEnum status, LocalDateTime entryDate
    ) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.chassis = chassis;
        this.licensePlate = licensePlate;
        this.modelYear = modelYear;
        this.manufacturerYear = manufacturerYear;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
        this.status = status;
        this.entryDate = entryDate;
    }

    public VehicleEntity(
            String name, VersionEntity version, String chassis, String licensePlate, Integer modelYear, Integer manufacturerYear,
            String color, Integer mileage, BigDecimal price, StatusVehicleEnum status, LocalDateTime entryDate
    ) {
        this.name = name;
        this.version = version;
        this.chassis = chassis;
        this.licensePlate = licensePlate;
        this.modelYear = modelYear;
        this.manufacturerYear = manufacturerYear;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
        this.status = status;
        this.entryDate = entryDate;
    }
}
