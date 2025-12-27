package br.com.carstock.main.features.vehicles.models;

import java.util.UUID;

public record ModelResponseDTO(
        UUID id,
        String name,
        boolean active,
        String brandName
) {}
