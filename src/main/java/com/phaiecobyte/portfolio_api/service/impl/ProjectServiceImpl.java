package com.phaiecobyte.portfolio_api.service.impl;

import com.phaiecobyte.portfolio_api.model.Project;
import com.phaiecobyte.portfolio_api.repository.ProjectRepository;
import com.phaiecobyte.portfolio_api.service.ProjectService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository repository;

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

        existProject.setUpdatedAt(LocalDateTime.now());

        return existProject;
    }

    @Override
    public void delete(long id) {
         repository.deleteById(id);
    }
}
