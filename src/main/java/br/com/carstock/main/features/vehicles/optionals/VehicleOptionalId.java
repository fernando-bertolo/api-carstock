package br.com.carstock.main.features.vehicles.optionals;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@EqualsAndHashCode
public class VehicleOptionalId implements Serializable {
    private UUID vehicleId;
    private UUID optionalId;
}
