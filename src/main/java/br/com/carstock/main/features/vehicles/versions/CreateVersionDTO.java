package br.com.carstock.main.features.vehicles.versions;

import java.util.UUID;

public record CreateVersionDTO(
    String name,
    UUID modelId,
    String engine,
    TransmissionTypeEnum transmission,
    FuelTypeEnum fuelType,
    boolean active
) {}
