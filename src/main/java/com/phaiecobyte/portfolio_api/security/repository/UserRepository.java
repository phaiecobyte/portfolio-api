package com.phaiecobyte.portfolio_api.security.repository;

import com.phaiecobyte.portfolio_api.security.model.TCoreUsr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<TCoreUsr, UUID> {
    Optional<TCoreUsr> findByUsername(String username);
}
