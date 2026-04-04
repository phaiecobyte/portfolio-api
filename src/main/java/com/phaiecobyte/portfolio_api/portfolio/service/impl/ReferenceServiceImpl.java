package com.phaiecobyte.portfolio_api.service.impl;

import com.phaiecobyte.portfolio_api.model.Reference;
import com.phaiecobyte.portfolio_api.repository.ReferenceRepository;
import com.phaiecobyte.portfolio_api.service.ReferenceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReferenceServiceImpl implements ReferenceService {
    private final ReferenceRepository repository;
    @Override
    public Long count(){
        return repository.count();
    }
    @Override
    public List<Reference> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Reference> paged(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Reference getById(long id) {
        return repository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Not found"));
    }

    @Override
    public Reference create(Reference reference) {
        return repository.save(reference);
    }

    @Override
    public Reference update(long id, Reference reference) {
        var existRef = repository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Not found"));
        existRef.setName(reference.getName());
        existRef.setEmail(reference.getEmail());
        existRef.setPhone(reference.getPhone());
        existRef.setPosition(reference.getPosition());
        existRef.setAddress(reference.getAddress());
        return repository.save(existRef);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
