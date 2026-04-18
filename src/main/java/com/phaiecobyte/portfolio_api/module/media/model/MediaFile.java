package com.phaiecobyte.portfolio_api.module.media.model;

import com.phaiecobyte.portfolio_api.common.AuditField;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "t_media")
@Getter @Setter @ToString @Builder @AllArgsConstructor @NoArgsConstructor
public class MediaFile extends AuditField {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String originalName;
    private String storedName;
    private String contentType;
    private long size;
    private String extension;
    private String storagePath;
    private String status;
}