package br.com.carstock.main.features.vehicles;


import java.util.List;

public interface IVehicleService {
    void create(CreateVehicleDTO dto);
    List<ResponseVehicleDTO> findAll(ParameterVehiclesDTO param);
}
