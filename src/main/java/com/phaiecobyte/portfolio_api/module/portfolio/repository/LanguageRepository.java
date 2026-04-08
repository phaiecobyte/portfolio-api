package com.phaiecobyte.portfolio_api.module.portfolio.repository;

import com.phaiecobyte.portfolio_api.module.portfolio.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language,Long> {
}
