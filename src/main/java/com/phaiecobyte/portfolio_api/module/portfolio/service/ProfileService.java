package com.phaiecobyte.portfolio_api.module.portfolio.service;

import com.phaiecobyte.portfolio_api.module.portfolio.model.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProfileService {
    List<Profile> getAll();
    Page<Profile> paged(Pageable pageable);
    Profile getById(long id);
    Profile create(String firstName, String lastName, String position, String bio, MultipartFile file) throws Exception;
    Profile update(long id, Profile profile) throws Exception;
    void delete(long id);
}
