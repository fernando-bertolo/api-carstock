package br.com.carstock.main.features.branches;

import br.com.carstock.main.features.addresses.AddressEntity;
import br.com.carstock.main.features.addresses.CreateAddressDTO;
import br.com.carstock.main.features.company.CompanyEntity;
import br.com.carstock.main.features.company.CreateCompanyDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateBranchDTO(
        String legalName,
        String tradeName,

        @NotBlank(message = "CNPJ is required")
        @Pattern(
                regexp = "^\\d{2}\\.?\\d{3}\\.?\\d{3}/?\\d{4}-?\\d{2}$",
                message = "CNPJ must be in valid format (XX.XXX.XXX/XXXX-XX)"
        )
        String cnpj,
        CreateCompanyDTO company,
        CreateAddressDTO address
) {
}
