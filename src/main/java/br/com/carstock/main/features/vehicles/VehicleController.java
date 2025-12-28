package br.com.carstock.main.features.vehicles;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseVehicleDTO>> getAllVehicles() {
        return ResponseEntity.ok(this.vehicleService.findAll());
    }

    @PostMapping
    public void createVehicle(@RequestBody CreateVehicleDTO vehicle) {
        this.vehicleService.create(vehicle);
    }
}
