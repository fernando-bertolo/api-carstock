package br.com.carstock.main.features.vehicles.versions;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IVersionService {
    void create(CreateVersionDTO dto);
    List<VersionResponseDTO> findAll();
    VersionEntity findById(UUID id);
}
