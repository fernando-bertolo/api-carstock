package br.com.carstock.main.features.company;

import java.util.List;
import java.util.Optional;

import br.com.carstock.main.shared.exceptions.ResourceConflictException;
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

    public Optional<CompanyEntity> findById(Long id) {
        return companyRepository.findById(id);
    }

    public Optional<CompanyEntity> update(Long id, CreateCompanyDTO dto) {
        return companyRepository.findById(id)
            .map(company -> {
                CompanyEntity updatedCompany = new CompanyEntity(id, dto.name(), dto.cnpj());
                return companyRepository.save(updatedCompany);
            });
    }

    public boolean delete(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
