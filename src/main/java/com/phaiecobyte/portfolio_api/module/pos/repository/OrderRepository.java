package com.phaiecobyte.portfolio_api.module.pos.repository;

import com.phaiecobyte.portfolio_api.module.pos.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
