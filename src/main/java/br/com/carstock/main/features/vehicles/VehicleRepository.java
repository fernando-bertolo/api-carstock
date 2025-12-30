package br.com.carstock.main.features.vehicles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, UUID> {
    @Query("""
        SELECT v FROM VehicleEntity v
        WHERE (:status IS NULL or v.status = :status)
    """)
    List<VehicleEntity> findAllWithFilter(@Param("status") StatusVehicleEnum status);
}
