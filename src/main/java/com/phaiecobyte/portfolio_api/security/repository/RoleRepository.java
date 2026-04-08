package com.phaiecobyte.portfolio_api.security.repository;

import com.phaiecobyte.portfolio_api.security.model.TCoreRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<TCoreRole,Long> {
    Optional<TCoreRole> findByName(String name);
}
