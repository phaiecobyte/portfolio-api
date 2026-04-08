package com.phaiecobyte.portfolio_api.portfolio.repository;

import com.phaiecobyte.portfolio_api.portfolio.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
