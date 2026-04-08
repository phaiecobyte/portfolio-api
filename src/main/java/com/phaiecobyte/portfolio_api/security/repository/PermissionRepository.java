package com.phaiecobyte.portfolio_api.security.repository;

import com.phaiecobyte.portfolio_api.security.model.TCorePerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<TCorePerm,Long> {
    Optional<TCorePerm> findByName(String name);
}
