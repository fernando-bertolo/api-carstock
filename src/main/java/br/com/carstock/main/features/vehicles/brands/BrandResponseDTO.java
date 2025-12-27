package br.com.carstock.main.features.vehicles.brands;

import java.util.UUID;

public record BrandResponseDTO(
        UUID id,
        String name,
        boolean active
) {}
