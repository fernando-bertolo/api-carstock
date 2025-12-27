package br.com.carstock.main.features.vehicles;

import br.com.carstock.main.features.vehicles.versions.CreateVersionDTO;

public interface IVehicleService {
    void create(CreateVersionDTO dto);
    void findAll();
}
