package br.com.carstock.main.features.vehicles.models;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IModelService {
    void create(CreateModelDTO brand);
    boolean update(ModelEntity brand, UUID id);
    boolean delete(UUID id);
    List<ModelEntity> findAll();
    Optional<ModelEntity> findById(UUID id);
}
