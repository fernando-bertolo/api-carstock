package br.com.carstock.main.features.vehicles.versions;

import br.com.carstock.main.features.vehicles.models.ModelEntity;

import java.util.List;

public class VersionMapper {
    public static VersionEntity toEntity(CreateVersionDTO dto, ModelEntity model) {
        return new VersionEntity(
                dto.name(),
                model,
                dto.engine(),
                dto.transmission(),
                dto.fuelType(),
                dto.active()
        );
    }

    public static List<VersionResponseDTO> toDTO(List<VersionEntity> versions) {
        return versions.stream()
                .map(version -> new VersionResponseDTO(
                        version.getId(),
                        version.getName(),
                        version.getModel().getBrand().getName(),
                        version.getModel().getName(),
                        version.getEngine(),
                        version.getTransmission(),
                        version.getFuelType(),
                        version.isActive()
                ))
                .toList();
    }

    public static VersionResponseDTO toDTO(VersionEntity version) {
        return new VersionResponseDTO(
                version.getId(),
                version.getName(),
                version.getModel().getBrand().getName(),
                version.getModel().getName(),
                version.getEngine(),
                version.getTransmission(),
                version.getFuelType(),
                version.isActive()
        );
    }
}
