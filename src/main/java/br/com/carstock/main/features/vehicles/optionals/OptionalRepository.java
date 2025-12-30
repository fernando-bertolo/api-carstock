package br.com.carstock.main.features.vehicles.optionals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OptionalRepository extends JpaRepository<OptionalEntity, UUID> {
}
