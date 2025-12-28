package br.com.carstock.main.features.vehicles;

import br.com.carstock.main.features.vehicles.versions.VersionEntity;
import br.com.carstock.main.features.vehicles.versions.VersionResponseDTO;
import br.com.carstock.main.features.vehicles.versions.VersionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService implements IVehicleService {

    private VehicleRepository vehicleRepository;
    private VersionService versionService;

    public VehicleService(VehicleRepository vehicleRepository, VersionService versionService) {
        this.vehicleRepository = vehicleRepository;
        this.versionService = versionService;
    }

    @Override
    public void create(CreateVehicleDTO dto) {
        VersionEntity version = this.versionService.findById(dto.versionId());
        this.vehicleRepository.save(VehicleMapper.toEntity(dto, version));
    }

    @Override
    public List<ResponseVehicleDTO> findAll() {
        List<VehicleEntity> vehicles = this.vehicleRepository.findAll();
        return VehicleMapper.toDTO(vehicles);
    }
}
