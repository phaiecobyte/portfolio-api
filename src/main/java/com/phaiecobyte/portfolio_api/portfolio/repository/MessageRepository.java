package com.phaiecobyte.portfolio_api.portfolio.repository;

import com.phaiecobyte.portfolio_api.portfolio.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
}
