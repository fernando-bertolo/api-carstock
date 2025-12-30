package br.com.carstock.main.features.vehicles.versions;

import java.util.UUID;

public record VersionResponseDTO (
        UUID id,
        String versionName,
        String brandName,
        String modelName,
        String engine,
        TransmissionTypeEnum transmission,
        FuelTypeEnum fuelType,
        boolean active
){}
