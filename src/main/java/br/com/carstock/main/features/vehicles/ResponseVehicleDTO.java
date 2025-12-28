package br.com.carstock.main.features.vehicles;

import java.time.LocalDateTime;

public record ResponseVehicleDTO(
        String name,
        String versionName,
        String modelName,
        String brandName,
        String chassis,
        String licensePlate,
        String color,
        String mileage,
        Double price,
        StatusVehicleEnum status,
        LocalDateTime entryDate
) {}
