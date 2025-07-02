package br.com.carstock.main.features.addresses;

import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressEntity create(CreateAddressDTO adressDTO) {
        this.addressRepository.findByNumberAndZipcode(adressDTO.number(), adressDTO.zipcode())
                .ifPresent(adress -> {
                    throw new RuntimeException("Address already exists");
                });

        AddressEntity addressEntity = new AddressEntity(
            adressDTO.street(),
            adressDTO.neighborhood(),
            adressDTO.city(),
            adressDTO.state(),
            adressDTO.country(),
            adressDTO.number(),
            adressDTO.zipcode()
        );
        return this.addressRepository.save(addressEntity);
    }

    public AddressEntity findById(Long id) {
        return this.addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found"));
    }

    public AddressEntity update(CreateAddressDTO adressDTO) {
        this.addressRepository.findByNumberAndZipcode(adressDTO.number(), adressDTO.zipcode())
                .orElseThrow(() -> new RuntimeException("Address not found"));

        AddressEntity addressEntity = new AddressEntity(
                adressDTO.street(),
                adressDTO.neighborhood(),
                adressDTO.city(),
                adressDTO.state(),
                adressDTO.country(),
                adressDTO.number(),
                adressDTO.zipcode()
        );

        return this.addressRepository.save(addressEntity);
    }

    public void delete(Long id) {
        this.addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found"));
        this.addressRepository.deleteById(id);
    }
}
