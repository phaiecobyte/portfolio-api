package com.phaiecobyte.portfolio_api.module.portfolio.service;

import com.phaiecobyte.portfolio_api.module.portfolio.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProjectService {
    Long count();
    List<Project> getAll();
    Page<Project> paged(Pageable pageable);
    Project getById(long id);
    Project create(Project project);
    Project update(long id, Project project);
    void delete(long id);
}
