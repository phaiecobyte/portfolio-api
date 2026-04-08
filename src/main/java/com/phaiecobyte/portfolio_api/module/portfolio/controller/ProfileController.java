package com.phaiecobyte.portfolio_api.module.portfolio.controller;


import com.phaiecobyte.portfolio_api.module.portfolio.model.Profile;
import com.phaiecobyte.portfolio_api.module.portfolio.repository.ProfileRepository;
import com.phaiecobyte.portfolio_api.module.portfolio.service.impl.ProfileServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileServiceImpl service;
    private final ProfileRepository repository;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/pagination")
    public ResponseEntity<Object> paged(Pageable pageable){
        return ResponseEntity.ok(service.paged(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getById(@PathVariable long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getProfileImage(@PathVariable Long id) {
        Profile profile = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found"));

        byte[] imageData = profile.getProfileImage();
        if (imageData == null || imageData.length == 0) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }

        MediaType mediaType = parseMediaTypeOrDefault(profile.getProfileImageType());

        return ResponseEntity.ok()
                .contentType(mediaType)
                .cacheControl(CacheControl.noCache())
                .body(imageData);
    }

    private MediaType parseMediaTypeOrDefault(String mediaTypeStr) {
        if (mediaTypeStr != null && !mediaTypeStr.isBlank()) {
            try {
                return MediaType.parseMediaType(mediaTypeStr); // e.g., "image/png"
            } catch (InvalidMediaTypeException ignored) {}
        }
        return MediaType.IMAGE_JPEG; // fallback to common type like image/jpeg
    }


    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Object> create(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("position") String position,
            @RequestParam("bio") String bio,
            @RequestParam(value = "profileImage", required = false) MultipartFile file
    ) {
        try {
            return ResponseEntity.ok(service.create(firstName,lastName,position,bio,file));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(
            @PathVariable("id") long id,
            @RequestBody Profile profile
            ){

        return ResponseEntity.ok(service.update(id,profile));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable long id){
        try {
            service.delete(id);
            return ResponseEntity.ok(Map.of("Message:","Deleted Successfully"));
        }catch (Exception ex){
            log.error("An unexpected error occurred! +",ex);
            return null;
        }finally {
            log.info("Delete operation completed");
        }
    }

    @PatchMapping(value = "/{id}/image",consumes = {"multipart/form-data"})
    public ResponseEntity<String> changeProfileImage(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) {

        Profile profile = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found"));

        try {
            // Save image bytes and MIME type
            profile.setProfileImage(file.getBytes());
            profile.setProfileImageType(file.getContentType());

            repository.save(profile);

            return ResponseEntity.ok("Profile image updated successfully");
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to upload image", e);
        }
    }


}
