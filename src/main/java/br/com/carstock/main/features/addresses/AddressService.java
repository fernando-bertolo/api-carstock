package br.com.carstock.main.features.addresses;

import br.com.carstock.main.shared.exceptions.ResourceConflictException;
import br.com.carstock.main.shared.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressEntity create(CreateAddressDTO adressDTO) {
        this.addressRepository.findByNumberAndZipcode(adressDTO.number(), adressDTO.zipcode())
                .ifPresent(adress -> {
                    throw new ResourceConflictException("Address already exists");
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

    public AddressEntity findById(UUID id) {
        return this.addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address not found"));
    }

    public AddressEntity update(CreateAddressDTO adressDTO) {
        this.addressRepository.findByNumberAndZipcode(adressDTO.number(), adressDTO.zipcode())
                .orElseThrow(() -> new ResourceNotFoundException("Address not found"));

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

    public void delete(UUID id) {
        this.addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address not found"));
        this.addressRepository.deleteById(id);
    }
}
