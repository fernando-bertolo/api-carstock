package br.com.carstock.main.features.addresses;

import org.springframework.stereotype.Service;

@Service
public class AdressService {
    private final AdressRepository adressRepository;

    public AdressService(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    public AdressEntity create(CreateAdressDTO adressDTO) {
        this.adressRepository.findByNumberAndZipcode(adressDTO.number(), adressDTO.zipcode())
                .ifPresent(adress -> {
                    throw new RuntimeException("Address already exists");
                });

        AdressEntity adressEntity = new AdressEntity(
            adressDTO.street(),
            adressDTO.neighborhood(),
            adressDTO.city(),
            adressDTO.state(),
            adressDTO.country(),
            adressDTO.number(),
            adressDTO.zipcode()
        );
        return this.adressRepository.save(adressEntity);
    }

    public AdressEntity findById(Long id) {
        return this.adressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found"));
    }

    public AdressEntity update(CreateAdressDTO adressDTO) {
        this.adressRepository.findByNumberAndZipcode(adressDTO.number(), adressDTO.zipcode())
                .orElseThrow(() -> new RuntimeException("Address not found"));

        AdressEntity adressEntity = new AdressEntity(
                adressDTO.street(),
                adressDTO.neighborhood(),
                adressDTO.city(),
                adressDTO.state(),
                adressDTO.country(),
                adressDTO.number(),
                adressDTO.zipcode()
        );

        return this.adressRepository.save(adressEntity);
    }
}
