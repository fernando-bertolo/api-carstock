package br.com.carstock.main.features.vehicles.optionals;

import java.util.List;

public interface IOptionalService {
    List<OptionalEntity> getAllOptionals();
    void saveOptional(CreateOptionalDTO dto);
}
