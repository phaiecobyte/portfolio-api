package com.phaiecobyte.portfolio_api.module.pos.repository;

import com.phaiecobyte.portfolio_api.module.pos.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Page<Category> findByStatus(String status, Pageable pageable);
}
