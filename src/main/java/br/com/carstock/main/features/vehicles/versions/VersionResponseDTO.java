package br.com.carstock.main.features.vehicles.versions;

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
