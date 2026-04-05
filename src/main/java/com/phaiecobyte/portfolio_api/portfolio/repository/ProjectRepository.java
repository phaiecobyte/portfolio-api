package com.phaiecobyte.portfolio_api.portfolio.repository;

import com.phaiecobyte.portfolio_api.portfolio.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
