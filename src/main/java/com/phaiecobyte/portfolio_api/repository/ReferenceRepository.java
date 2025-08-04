package com.phaiecobyte.portfolio_api.repository;

import com.phaiecobyte.portfolio_api.model.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceRepository extends JpaRepository<Reference,Long> {
}
