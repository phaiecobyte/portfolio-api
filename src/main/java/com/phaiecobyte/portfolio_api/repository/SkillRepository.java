package com.phaiecobyte.portfolio_api.repository;

import com.phaiecobyte.portfolio_api.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Long> {
}
