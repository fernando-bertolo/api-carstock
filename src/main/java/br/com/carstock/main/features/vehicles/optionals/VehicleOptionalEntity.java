package br.com.carstock.main.features.vehicles.optionals;

import br.com.carstock.main.features.vehicles.VehicleEntity;
import jakarta.persistence.*;

@Table(name = "vehicle_optionals")
@Entity
public class VehicleOptionalEntity {
    @EmbeddedId
    private VehicleOptionalId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("vehicleId")
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("optionalId")
    @JoinColumn(name = "optional_id")
    private OptionalEntity optional;
}
