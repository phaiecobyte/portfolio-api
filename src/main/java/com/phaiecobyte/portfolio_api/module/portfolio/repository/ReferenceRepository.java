package com.phaiecobyte.portfolio_api.module.portfolio.repository;

import com.phaiecobyte.portfolio_api.module.portfolio.model.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceRepository extends JpaRepository<Reference,Long> {
}
