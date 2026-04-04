package com.phaiecobyte.portfolio_api.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;

import java.time.Instant;

@MappedSuperclass
public class BaseEntity {
    private Instant createAt;
    private String createdBy;
    private Instant updatedAt;
    private String updatedBy;

    @PrePersist
    void persist(){
        this.createAt = Instant.now();
        this.createdBy = "sys";
    }
}
