package com.phaiecobyte.portfolio_api.module.media.service;

import com.phaiecobyte.portfolio_api.module.media.model.MediaFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

public interface MediaService {
    //Upload
    MediaFile upload(MultipartFile file);

    //Read
    MediaFile getById(UUID uuid);

    Page<MediaFile> listMediaFiles(String status, Pageable pageable);

    // Download (Product ↔ Media ready)
    MediaResource loadAsResource(UUID id);

    // Delete (soft delete)
    void delete(UUID id);

    // ================= DOMAIN HELPER =================
    record MediaResource(
            InputStream inputStream,
            String contentType,
            String filename
    ) {}
}
