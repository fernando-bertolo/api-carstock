package br.com.carstock.main.features.vehicles.brands;

import java.util.List;
import java.util.UUID;

public interface IBrandService {
    void create(BrandEntity brand);
    boolean update(BrandEntity brand, UUID id);
    boolean delete(UUID id);
    List<BrandEntity> findAll();
    BrandEntity findById(UUID id);
}
