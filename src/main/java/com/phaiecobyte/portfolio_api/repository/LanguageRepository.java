package com.phaiecobyte.portfolio_api.repository;

import com.phaiecobyte.portfolio_api.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language,Long> {
}
