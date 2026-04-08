package com.phaiecobyte.portfolio_api.module.portfolio.service.impl;


import com.phaiecobyte.portfolio_api.module.portfolio.model.Project;
import com.phaiecobyte.portfolio_api.module.portfolio.repository.ProjectRepository;
import com.phaiecobyte.portfolio_api.module.portfolio.service.ProjectService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository repository;
    @Override
    public Long count(){
        return repository.count();
    }
    @Override
    public List<Project> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Project> paged(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Project getById(long id) {
        return repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Project is not found width id"+id));
    }

    @Override
    public Project create(Project project) {
        return repository.save(project);
    }

    @Override
    public Project update(long id, Project project) {
        var existProject = repository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Project is not found with id:"+id));

        existProject.setName(project.getName());
        existProject.setDescription(project.getDescription());
        existProject.setTech(project.getTech());
        existProject.setSourceCodeUrl(project.getSourceCodeUrl());
        existProject.setDemoVideoUrl(project.getDemoVideoUrl());


        return repository.save(existProject);
    }

    @Override
    public void delete(long id) {
         repository.deleteById(id);
    }
}
