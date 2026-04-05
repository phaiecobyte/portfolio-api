package com.phaiecobyte.portfolio_api.portfolio.service.impl;


import com.phaiecobyte.portfolio_api.portfolio.model.Profile;
import com.phaiecobyte.portfolio_api.portfolio.repository.ProfileRepository;
import com.phaiecobyte.portfolio_api.portfolio.service.ProfileService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository repository;

    @Override
    public List<Profile> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Profile> paged(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Profile getById(long id) {
        return repository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Profile is not found with id:"+id));
    }

    @Override
    public Profile create(String firstName, String lastName, String position, String bio, MultipartFile file) throws Exception{
        Profile profile = new Profile();
        profile.setFirstName(firstName);
        profile.setLastName(lastName);
        profile.setPosition(position);
        profile.setBio(bio);

        if (file != null && !file.isEmpty()) {
            try {
                profile.setProfileImage(file.getBytes());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read file bytes", e);
            }
        }
        return repository.save(profile);
    }

    @Override
    public Profile update(long id, Profile updatedData) {
        Profile existingProfile = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));

        existingProfile.setFirstName(updatedData.getFirstName());
        existingProfile.setLastName(updatedData.getLastName());
        existingProfile.setBio(updatedData.getBio());
        existingProfile.setPosition(updatedData.getPosition());

        return repository.save(existingProfile);
    }

    @Override
    public void delete(long id) {
        var existProfile = repository.findById(id)
                        .orElseThrow(()->new EntityNotFoundException("Profile is not found with id:"+id));
        if(existProfile != null){
            repository.deleteById(existProfile.getId());
        }
    }
}
