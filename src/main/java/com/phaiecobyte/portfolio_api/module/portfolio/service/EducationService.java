package com.phaiecobyte.portfolio_api.module.portfolio.service;

import com.phaiecobyte.portfolio_api.module.portfolio.model.Education;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EducationService {
    Long count();
    List<Education> getAll();
    Page<Education> paged(Pageable pageable);
    Education getById(long id);
    Education create(Education education);
    Education update(long id, Education education);
    void delete(long id);
}
