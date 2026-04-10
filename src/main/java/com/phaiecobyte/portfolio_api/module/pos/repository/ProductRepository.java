package com.phaiecobyte.portfolio_api.module.pos.repository;

import com.phaiecobyte.portfolio_api.module.pos.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findByStatus(String status, Pageable pageable);
}
