package com.phaiecobyte.portfolio_api.module.portfolio.repository;

import com.phaiecobyte.portfolio_api.module.portfolio.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Long> {
}
