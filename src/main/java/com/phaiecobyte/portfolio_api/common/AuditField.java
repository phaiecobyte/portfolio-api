package com.phaiecobyte.portfolio_api.common;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;

import java.time.Instant;

@MappedSuperclass
public class AuditField {
    private String createdBy;
    private Instant createdAt;
    private String updatedBy;
    private Instant updatedAt;

    @PrePersist
    void persist(){
        this.createdAt = Instant.now();
    }
}
