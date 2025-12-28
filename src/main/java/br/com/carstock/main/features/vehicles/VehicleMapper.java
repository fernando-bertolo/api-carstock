package br.com.carstock.main.features.vehicles;

import br.com.carstock.main.features.vehicles.versions.VersionEntity;

import java.util.List;

public class VehicleMapper {

    public static VehicleEntity toEntity(CreateVehicleDTO vehicleDTO, VersionEntity version) {
        return new VehicleEntity(
                vehicleDTO.name(),
                version,
                vehicleDTO.chassis(),
                vehicleDTO.licensePlate(),
                vehicleDTO.color(),
                vehicleDTO.mileage(),
                vehicleDTO.price(),
                vehicleDTO.status(),
                vehicleDTO.entryDate()
        );
    }

    public static List<ResponseVehicleDTO> toDTO(List<VehicleEntity> vehicles) {
        return vehicles.stream()
                .map(vehicle -> new ResponseVehicleDTO(
                        vehicle.getName(),
                        vehicle.getVersion().getName(),
                        vehicle.getVersion().getModel().getName(),
                        vehicle.getVersion().getModel().getBrand().getName(),
                        vehicle.getChassis(),
                        vehicle.getLicensePlate(),
                        vehicle.getColor(),
                        vehicle.getMileage(),
                        vehicle.getPrice(),
                        vehicle.getStatus(),
                        vehicle.getEntryDate()
                )).toList();
    }
}
