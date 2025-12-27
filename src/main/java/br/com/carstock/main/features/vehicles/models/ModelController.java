package br.com.carstock.main.features.vehicles.models;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/models")
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public ResponseEntity<List<ModelResponseDTO>> getAllModels() {
        List<ModelEntity> brands = this.modelService.findAll();
        return ResponseEntity.ok(ModelMapper.toDTO(brands));
    }

    @PostMapping
    public void createModel(@RequestBody CreateModelDTO dto) {
        this.modelService.create(dto);
    }
}
