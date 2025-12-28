package br.com.carstock.main.features.vehicles.versions;

import br.com.carstock.main.features.vehicles.models.ModelEntity;
import br.com.carstock.main.features.vehicles.models.ModelRepository;
import br.com.carstock.main.features.vehicles.models.ModelService;
import br.com.carstock.main.shared.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VersionService implements IVersionService {
    private final VersionRepository versionRepository;
    private final ModelService modelService;

    public VersionService(VersionRepository versionRepository, ModelService modelService) {
        this.versionRepository = versionRepository;
        this.modelService = modelService;
    }

    @Override
    public void create(CreateVersionDTO dto) {
        ModelEntity model = this.modelService.findById(dto.modelId());
        this.versionRepository.save(VersionMapper.toEntity(dto, model));
    }

    @Override
    public List<VersionResponseDTO> findAll() {
        return VersionMapper.toDTO(this.versionRepository.findAll());
    }

    @Override
    public VersionEntity findById(UUID id) {
        return this.versionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Version not found"));
    }
}
