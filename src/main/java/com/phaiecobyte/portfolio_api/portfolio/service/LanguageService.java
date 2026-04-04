package com.phaiecobyte.portfolio_api.service;

import com.phaiecobyte.portfolio_api.model.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LanguageService {
    Long count();
    List<Language> getAll();
    Page<Language> paged(Pageable pageable);
    Language getById(long id);
    Language create(Language language);
    Language update(long id,Language language);
    void delete(long id);
}
