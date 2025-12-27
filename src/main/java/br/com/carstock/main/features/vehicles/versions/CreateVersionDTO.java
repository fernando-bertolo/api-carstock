package br.com.carstock.main.features.vehicles.versions;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.UUID;

public record CreateVersionDTO(
    String name,
    UUID modelId,

    @Min(1900)
    @Max(9999)
    Integer modelYear,
    String engine,
    TransmissionTypeEnum transmission,
    FuelTypeEnum fuelType,
    boolean active
) {}
