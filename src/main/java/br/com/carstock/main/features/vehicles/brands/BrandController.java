package br.com.carstock.main.features.vehicles.brands;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<List<BrandResponseDTO>> getAllBrands() {
        List<BrandEntity> brands = this.brandService.findAll();
        return ResponseEntity.ok(BrandMapper.toDTO(brands));
    }

    @PostMapping
    public void createBrand(@RequestBody CreateBrandDTO requestBrand) {
        this.brandService.create(BrandMapper.toEntity(requestBrand));
    }
}
