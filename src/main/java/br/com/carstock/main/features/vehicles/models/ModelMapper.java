package br.com.carstock.main.features.vehicles.models;

import br.com.carstock.main.features.vehicles.brands.BrandEntity;
import br.com.carstock.main.features.vehicles.brands.BrandMapper;

import java.util.List;

public class ModelMapper {
    public static List<ModelResponseDTO> toDTO(List<ModelEntity> models) {
        return models.stream()
                .map(model -> new ModelResponseDTO(
                    model.getId(),
                    model.getName(),
                    model.isActive(),
                    model.getBrand().getName()
                ))
                .toList();
    }

    public static ModelResponseDTO toDTO(ModelEntity model) {
        return new ModelResponseDTO(
                model.getId(),
                model.getName(),
                model.isActive(),
                model.getBrand().getName());
    }

    public static ModelEntity toEntity(CreateModelDTO dto, BrandEntity brand) {
        return new ModelEntity(dto.name(), dto.active(), brand);
    }
}
