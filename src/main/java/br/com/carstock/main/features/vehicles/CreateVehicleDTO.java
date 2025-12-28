package br.com.carstock.main.features.vehicles;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record CreateVehicleDTO(
        String name,
        UUID versionId,
        String chassis,
        String licensePlate,
        String color,
        Integer mileage,
        BigDecimal price,
        StatusVehicleEnum status,
        LocalDateTime entryDate
) {}
