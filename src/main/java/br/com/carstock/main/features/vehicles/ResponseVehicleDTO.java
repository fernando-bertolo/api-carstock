package br.com.carstock.main.features.vehicles;

import br.com.carstock.main.features.vehicles.versions.FuelTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ResponseVehicleDTO(
        UUID id,
        String name,
        String versionName,
        String modelName,
        String brandName,
        Integer modelYear,
        Integer manufacturerYear,
        String chassis,
        String licensePlate,
        String color,
        Integer mileage,
        BigDecimal price,
        FuelTypeEnum fuelType,
        StatusVehicleEnum status,
        LocalDateTime entryDate
) {}
