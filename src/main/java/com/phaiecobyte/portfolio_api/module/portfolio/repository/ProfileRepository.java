package com.phaiecobyte.portfolio_api.portfolio.repository;

import com.phaiecobyte.portfolio_api.portfolio.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
