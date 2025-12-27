package br.com.carstock.main.features.vehicles.brands;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BrandService implements IBrandService{

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public void create(BrandEntity brand) {

    }

    @Override
    public boolean update(BrandEntity brand, UUID id) {
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public List<BrandEntity> findAll() {
        return List.of();
    }
}
