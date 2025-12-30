package br.com.carstock.main.features.vehicles.optionals;

import java.util.List;

public class OptionalMapper {
    public static List<OptionalResponseDTO> toDTO(List<OptionalEntity> optionals) {
        return optionals.stream()
                .map(optional -> new OptionalResponseDTO(
                        optional.getId(),
                        optional.getName()
                )).toList();
    }

    public static OptionalEntity toEntity(CreateOptionalDTO dto) {
        return new OptionalEntity(dto.name());
    }
}
