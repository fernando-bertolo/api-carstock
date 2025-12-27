package br.com.carstock.main.features.vehicles.versions;
import java.util.List;

public interface IVersionService {
    void create(CreateVersionDTO dto);
    List<VersionResponseDTO> findAll();
}
