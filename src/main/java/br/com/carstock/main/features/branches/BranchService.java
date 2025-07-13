package br.com.carstock.main.features.branches;

import br.com.carstock.main.features.addresses.AddressEntity;
import br.com.carstock.main.features.addresses.AddressService;
import br.com.carstock.main.features.addresses.CreateAddressDTO;
import br.com.carstock.main.features.company.CompanyEntity;
import br.com.carstock.main.features.company.CompanyService;
import br.com.carstock.main.shared.exceptions.ResourceConflictException;
import br.com.carstock.main.shared.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BranchService {
    private final BranchRepository branchRepository;
    private final AddressService addressService;
    private final CompanyService companyService;

    public BranchService(
            BranchRepository branchRepository,
            AddressService addressService,
            CompanyService companyService
    ) {
        this.branchRepository = branchRepository;
        this.addressService = addressService;
        this.companyService = companyService;
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
        AddressEntity addressSaved = this.addressService.create(addressDTO);

        CompanyEntity company = this.companyService.findByCnpj(dto.company().cnpj())
                .orElseThrow(() -> new ResourceNotFoundException("Company with this CNPJ not found"));

        BranchEntity branch = new BranchEntity(
                dto.legalName(),
                dto.tradeName(),
                dto.cnpj(),
                company,
                addressSaved
        );
        return this.branchRepository.save(branch);
    }
}
