package com.phaiecobyte.portfolio_api.module.portfolio.service.impl;


import com.phaiecobyte.portfolio_api.module.portfolio.model.Skill;
import com.phaiecobyte.portfolio_api.module.portfolio.repository.SkillRepository;
import com.phaiecobyte.portfolio_api.module.portfolio.service.SkillService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillRepository repository;
    @Override
    public Long count(){
        return repository.count();
    }
    @Override
    public List<Skill> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Skill> paged(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Skill> getById(long id) {
        return repository.findById(id);
    }

    @Override
    public Skill create(Skill skill) {
        return repository.save(skill);
    }

    @Override
    public Skill update(long id, Skill skill) {
        var existSkill = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Not found"));

        existSkill.setName(skill.getName());
        existSkill.setIcon(skill.getIcon());
        existSkill.setLevel(skill.getLevel());

        return repository.save(existSkill);
    }

    @Override
    public void delete(long id) {
         repository.deleteById(id);
    }
}
