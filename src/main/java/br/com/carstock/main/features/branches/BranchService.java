package br.com.carstock.main.features.branches;

import br.com.carstock.main.features.addresses.AddressEntity;
import br.com.carstock.main.features.addresses.AddressService;
import br.com.carstock.main.features.addresses.CreateAddressDTO;
import br.com.carstock.main.features.company.CompanyEntity;
import br.com.carstock.main.shared.exceptions.ResourceConflictException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BranchService {
    private final BranchRepository branchRepository;
    private final AddressService addressService;

    public BranchService(BranchRepository branchRepository, AddressService addressService) {
        this.branchRepository = branchRepository;
        this.addressService = addressService;
    }

    public List<BranchEntity> findAll() {
        return this.branchRepository.findAll();
    }


    @Transactional
    public BranchEntity create(CreateBranchDTO dto) {
        Optional<BranchEntity> existBranchCnpj = this.branchRepository.findByCnpj(dto.cnpj());

        if(existBranchCnpj.isPresent()) {
            throw new ResourceConflictException("Branch with this CNPJ already exists");
        }

        CreateAddressDTO addressDTO = new CreateAddressDTO(
                dto.address().street(),
                dto.address().neighborhood(),
                dto.address().city(),
                dto.address().state(),
                dto.address().country(),
                dto.address().number(),
                dto.address().zipcode()
        );
        this.addressService.create(addressDTO);

        BranchEntity branch = new BranchEntity(
                dto.legalName(),
                dto.tradeName(),
                dto.cnpj(),
                new CompanyEntity(
                        dto.company().name(),
                        dto.company().cnpj()
                ),
                new AddressEntity(
                        dto.address().street(),
                        dto.address().neighborhood(),
                        dto.address().city(),
                        dto.address().state(),
                        dto.address().country(),
                        dto.address().number(),
                        dto.address().zipcode()
                )
        );
        return this.branchRepository.save(branch);
    }
}
