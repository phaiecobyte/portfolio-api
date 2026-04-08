package com.phaiecobyte.portfolio_api.module.portfolio.repository;

import com.phaiecobyte.portfolio_api.module.portfolio.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
}
