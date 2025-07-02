package br.com.carstock.main.features.addresses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdressRepository extends JpaRepository<AdressEntity, Long> {
    Optional<AdressEntity> findByNumberAndZipcode(Integer number, String zipcode);
}
