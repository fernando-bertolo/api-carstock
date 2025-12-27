package br.com.carstock.main.features.vehicles.versions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/versions")
public class VersionController {
    private final VersionService versionService;

    public VersionController(VersionService versionService) {
        this.versionService = versionService;
    }

    @GetMapping
    public ResponseEntity<List<VersionResponseDTO>> getAllVersions() {
        return ResponseEntity.ok(this.versionService.findAll());
    }

    @PostMapping
    public void createVersion(@RequestBody CreateVersionDTO createVersionDTO) {
        this.versionService.create(createVersionDTO);
    }
}
