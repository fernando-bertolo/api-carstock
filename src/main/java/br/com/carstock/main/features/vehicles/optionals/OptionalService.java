package br.com.carstock.main.features.vehicles.optionals;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionalService implements IOptionalService {

    private final OptionalRepository optionalRepository;

    public OptionalService(OptionalRepository optionalRepository) {
        this.optionalRepository = optionalRepository;
    }

    @Override
    public List<OptionalEntity> getAllOptionals() {
        return this.optionalRepository.findAll();
    }

    @Override
    public void saveOptional(CreateOptionalDTO dto) {
        this.optionalRepository.save(OptionalMapper.toEntity(dto));
    }
}
