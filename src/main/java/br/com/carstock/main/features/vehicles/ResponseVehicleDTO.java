package br.com.carstock.main.features.vehicles;

import br.com.carstock.main.features.vehicles.versions.FuelTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ResponseVehicleDTO(
        String name,
        String versionName,
        String modelName,
        String brandName,
        String chassis,
        String licensePlate,
        String color,
        Integer mileage,
        BigDecimal price,
        FuelTypeEnum fuelType,
        StatusVehicleEnum status,
        LocalDateTime entryDate
) {}
