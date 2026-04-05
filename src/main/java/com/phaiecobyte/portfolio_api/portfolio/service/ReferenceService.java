package com.phaiecobyte.portfolio_api.portfolio.service;


import com.phaiecobyte.portfolio_api.portfolio.model.Reference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReferenceService {
    Long count();
    List<Reference> getAll();
    Page<Reference> paged(Pageable pageable);
    Reference getById(long id);
    Reference create(Reference reference);
    Reference update(long id,Reference reference);
    void delete(long id);
}
