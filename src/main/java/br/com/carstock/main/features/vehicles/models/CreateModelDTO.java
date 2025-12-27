package br.com.carstock.main.features.vehicles.models;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record CreateModelDTO(
        @NotBlank(message = "O nome da marca é obrigatório")
        String name,
        boolean active,
        UUID brandId
) {}
