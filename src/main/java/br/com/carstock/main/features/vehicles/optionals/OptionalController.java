package br.com.carstock.main.features.vehicles.optionals;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/optionals")
public class OptionalController {
    private final OptionalService optionalService;

    public OptionalController(OptionalService optionalService) {
        this.optionalService = optionalService;
    }

    @GetMapping
    public ResponseEntity<List<OptionalResponseDTO>> getOptionals() {
        return ResponseEntity.ok(OptionalMapper.toDTO(this.optionalService.getAllOptionals()));
    }

    @PostMapping
    public void createOptional(@RequestBody CreateOptionalDTO dto) {
        this.optionalService.saveOptional(dto);
    }

}
