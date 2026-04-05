package com.phaiecobyte.portfolio_api.portfolio.repository;

import com.phaiecobyte.portfolio_api.portfolio.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language,Long> {
}
