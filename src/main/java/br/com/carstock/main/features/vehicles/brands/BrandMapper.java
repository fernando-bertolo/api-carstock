package br.com.carstock.main.features.vehicles.brands;

import java.util.List;

public class BrandMapper {
    public static List<BrandResponseDTO> toDTO(List<BrandEntity> brands) {
        return brands.stream()
                .map(brand -> new BrandResponseDTO(
                    brand.getId(),
                    brand.getName(),
                    brand.isActive()
                ))
                .toList();
    }

    public static BrandEntity toEntity(CreateBrandDTO dto) {
        return new BrandEntity(dto.name(), dto.active());
    }
}
