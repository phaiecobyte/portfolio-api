package com.phaiecobyte.portfolio_api.repository;

import com.phaiecobyte.portfolio_api.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
}
