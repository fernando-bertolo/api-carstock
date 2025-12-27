package br.com.carstock.main.features.vehicles.versions;

import br.com.carstock.main.features.vehicles.models.ModelResponseDTO;

public record VersionResponseDTO (
    String versionName,
    String brandName,
    String modelName,
    Integer modelYear,
    String engine,
    TransmissionTypeEnum transmission,
    FuelTypeEnum fuelType,
    boolean active
){}
