package br.com.carstock.main.features.addresses;

import jakarta.validation.constraints.*;

public record CreateAdressDTO(
        @NotBlank(message = "Street is required")
        @Size(min = 5, max = 100, message = "Street must be between 5 and 100 characters")
        String street,

        @NotBlank(message = "Neighborhood is required")
        @Size(min = 2, max = 50, message = "Neighborhood must be between 2 and 50 characters")
        String neighborhood,

        @NotBlank(message = "City is required")
        @Size(min = 2, max = 50, message = "City must be between 2 and 50 characters")
        @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s'-]+$", message = "City must contain only letters, spaces, hyphens and apostrophes")
        String city,

        @NotBlank(message = "State is required")
        @Size(min = 2, max = 2, message = "State must be exactly 2 characters")
        @Pattern(regexp = "^[A-Z]{2}$", message = "State must be 2 uppercase letters")
        String state,

        @NotBlank(message = "Country is required")
        @Size(min = 2, max = 30, message = "Country must be between 2 and 30 characters")
        @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "Country must contain only letters and spaces")
        String country,

        @NotNull(message = "Number is required")
        @Positive(message = "Number must be positive")
        @Max(value = 99999, message = "Number must not exceed 99999")
        Integer number,

        @NotBlank(message = "Zipcode is required")
        @Pattern(regexp = "^\\d{5}-?\\d{3}$", message = "Zipcode must follow the format 12345-678 or 12345678")
        String zipcode
) {
}
