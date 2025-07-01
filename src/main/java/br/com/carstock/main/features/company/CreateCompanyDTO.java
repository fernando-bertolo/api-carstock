package br.com.carstock.main.features.company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateCompanyDTO(
    @NotBlank(message = "Name is required")
    String name,
    
    @NotBlank(message = "CNPJ is required")
    @Pattern(
        regexp = "^\\d{2}\\.?\\d{3}\\.?\\d{3}/?\\d{4}-?\\d{2}$",
        message = "CNPJ must be in valid format (XX.XXX.XXX/XXXX-XX)"
    )
    String cnpj
) {}