package com.phaiecobyte.portfolio_api.service.impl;

import com.phaiecobyte.portfolio_api.model.Language;
import com.phaiecobyte.portfolio_api.repository.LanguageRepository;
import com.phaiecobyte.portfolio_api.service.LanguageService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository repository;
    @Override
    public Long count(){
        return repository.count();
    }
    @Override
    public List<Language> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Language> paged(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Language getById(long id) {
        return repository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Not found"));
    }

    @Override
    public Language create(Language language) {
        return repository.save(language);
    }

    @Override
    public Language update(long id, Language language) {
        var exitLang = repository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Not found"));
        exitLang.setIcon(language.getIcon());
        exitLang.setName(language.getName());
        exitLang.setLevel(language.getLevel());

        return repository.save(exitLang);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
