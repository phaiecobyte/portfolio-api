package com.phaiecobyte.portfolio_api.portfolio.service.impl;


import com.phaiecobyte.portfolio_api.portfolio.model.Experience;
import com.phaiecobyte.portfolio_api.portfolio.repository.ExperienceRepository;
import com.phaiecobyte.portfolio_api.portfolio.service.ExperienceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {
    private final ExperienceRepository repository;
    @Override
    public Long count(){
        return repository.count();
    }
    @Override
    public List<Experience> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Experience> paged(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Experience getById(long id) {
        return repository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Experience is not found with id:"+id));
    }

    @Override
    public Experience create(Experience experience) {
        return repository.save(experience);
    }

    @Override
    public Experience update(long id, Experience experience) {
        var existExp = repository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Experience is not found with id:"+id));
        existExp.setPosition(experience.getPosition());
        existExp.setStartDate(experience.getStartDate());
        existExp.setEndDate(experience.getEndDate());
        existExp.setDescription(experience.getDescription());
        return repository.save(existExp);
    }

    @Override
    public void delete(long id) {
        var existExp = repository.findById(id)
                        .orElseThrow(()->new EntityNotFoundException("Experience is not found with id:"+id));
        if(existExp != null){
            repository.deleteById(existExp.getId());
        }
    }
}
