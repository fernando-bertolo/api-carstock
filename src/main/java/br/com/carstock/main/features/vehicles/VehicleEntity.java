package br.com.carstock.main.features.vehicles;

import br.com.carstock.main.features.vehicles.versions.VersionEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "version_id", nullable = false)
    private VersionEntity version;

    private String chassis;

    @Column(name = "license_plate")
    private String licensePlate;

    private String color;

    private String mileage;

    private Double price;

    @Enumerated(EnumType.STRING)
    private StatusVehicleEnum status;

    @Column(name = "entry_date")
    private LocalDateTime entryDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public VehicleEntity() {}

    public VehicleEntity(
            UUID id, String name, VersionEntity version, String chassis, String licensePlate, String color,
            String mileage, Double price, StatusVehicleEnum status, LocalDateTime entryDate
    ) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.chassis = chassis;
        this.licensePlate = licensePlate;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
        this.status = status;
        this.entryDate = entryDate;
    }

    public VehicleEntity(
            String name, VersionEntity version, String chassis, String licensePlate, String color,
            String mileage, Double price, StatusVehicleEnum status, LocalDateTime entryDate
    ) {
        this.name = name;
        this.version = version;
        this.chassis = chassis;
        this.licensePlate = licensePlate;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
        this.status = status;
        this.entryDate = entryDate;
    }
}
