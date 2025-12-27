package br.com.carstock.main.features.vehicles.brands;

import jakarta.validation.constraints.NotBlank;

public record CreateBrandDTO(
        @NotBlank(message = "O nome da marca é obrigatório")
        String name,
        boolean active
) {}
