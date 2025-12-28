package br.com.carstock.main.features.vehicles;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateVehicleDTO(
        String name,
        UUID versionId,
        String chassis,
        String licensePlate,
        String color,
        String mileage,
        Double price,
        StatusVehicleEnum status,
        LocalDateTime entryDate
) {}
