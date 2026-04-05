package com.phaiecobyte.portfolio_api.portfolio.service.impl;


import com.phaiecobyte.portfolio_api.portfolio.model.Education;
import com.phaiecobyte.portfolio_api.portfolio.repository.EducationRepository;
import com.phaiecobyte.portfolio_api.portfolio.service.EducationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {
    private final EducationRepository repository;

    @Override
    public Long count(){
        return repository.count();
    }

    @Override
    public List<Education> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Education> paged(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Education getById(long id) {
        return repository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Education is not found with id:"+id));
    }

    @Override
    public Education create(Education edu) {
        return repository.save(edu);
    }

    @Override
    public Education update(long id, Education edu) {
        var existEdu = repository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Edu is not found with id:"+id));
        existEdu.setDegree(edu.getDegree());
        existEdu.setMajor(edu.getMajor());
        existEdu.setSchool(edu.getSchool());
        existEdu.setStartDate(edu.getStartDate());
        existEdu.setEndDate(edu.getEndDate());
        existEdu.setAddress(edu.getAddress());

        return this.repository.save(existEdu);
    }

    @Override
    public void delete(long id) {
        var existEdu = repository.findById(id)
                        .orElseThrow(()->new EntityNotFoundException("Edu is not found with id:"+id));
        if(existEdu != null){
            repository.deleteById(existEdu.getId());
        }
    }
}
