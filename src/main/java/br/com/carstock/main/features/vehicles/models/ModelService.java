package br.com.carstock.main.features.vehicles.models;

import br.com.carstock.main.features.vehicles.brands.BrandEntity;
import br.com.carstock.main.features.vehicles.brands.BrandService;
import br.com.carstock.main.shared.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ModelService implements IModelService {

    private final ModelRepository modelRepository;
    private final BrandService brandService;

    public ModelService(ModelRepository modelRepository, BrandService brandService) {
        this.modelRepository = modelRepository;
        this.brandService = brandService;
    }

    @Override
    public void create(CreateModelDTO model) {
        BrandEntity brand = this.brandService.findById(model.brandId())
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found"));
        this.modelRepository.save(ModelMapper.toEntity(model, brand));
    }

    @Override
    public boolean update(ModelEntity brand, UUID id) {
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public List<ModelEntity> findAll() {
        return this.modelRepository.findAll();
    }

    @Override
    public Optional<ModelEntity> findById(UUID id) {
        return this.modelRepository.findById(id);
    }
}
