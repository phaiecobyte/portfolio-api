package com.phaiecobyte.portfolio_api.service;

import com.phaiecobyte.portfolio_api.model.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SkillService {
    Long count();
    List<Skill> getAll();
    Page<Skill> paged(Pageable pageable);
    Optional<Skill> getById(long id);
    Skill create(Skill skill);
    Skill update(long id, Skill skill);
    void delete(long id);
}
