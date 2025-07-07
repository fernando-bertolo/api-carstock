package br.com.carstock.main.features.company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.carstock.main.shared.exceptions.ResourceConflictException;
import br.com.carstock.main.shared.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyEntity create(CreateCompanyDTO dto) {
        Optional<CompanyEntity> existCompanyCnpj = companyRepository.findByCnpj(dto.cnpj());

        if(existCompanyCnpj.isPresent()) {
          throw new ResourceConflictException("Company with this CNPJ already exists");
        }

        CompanyEntity company = new CompanyEntity(dto.name(), dto.cnpj());
        return companyRepository.save(company);
    }

    public List<CompanyEntity> findAll() {
        return companyRepository.findAll();
    }

    public CompanyEntity findById(UUID id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company with id " + id + " not found"));
    }

    public CompanyEntity update(UUID id, CreateCompanyDTO dto) {
        CompanyEntity company = this.findById(id);

        CompanyEntity companyEntity = new CompanyEntity(id, dto.name(), dto.cnpj());

        return companyRepository.save(companyEntity);
    }

    public void delete(UUID id) {
        this.findById(id);
        companyRepository.deleteById(id);
    }
}
