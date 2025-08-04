package com.phaiecobyte.portfolio_api.service;

import com.phaiecobyte.portfolio_api.model.Experience;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExperienceService {
    Long count();
    List<Experience> getAll();
    Page<Experience> paged(Pageable pageable);
    Experience getById(long id);
    Experience create(Experience experience);
    Experience update(long id,Experience experience);
    void delete(long id);
}
