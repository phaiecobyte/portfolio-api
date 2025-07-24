package com.phaiecobyte.portfolio_api.service;

import com.phaiecobyte.portfolio_api.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProjectService {
    List<Project> getAll();
    Page<Project> paged(Pageable pageable);
    Project getById(long id);
    Project create(Project project);
    Project update(long id, Project project);
    void delete(long id);
}
