package com.phaiecobyte.portfolio_api.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@MappedSuperclass
@Getter
@Setter
public abstract class AuditField {
    @Column(name = "created_by", length = 50)
    protected String createdBy;
    @Column(name = "created_at")
    protected Instant createdAt;
    @Column(name = "updated_by",length = 50)
    protected String updatedBy;
    @Column(name = "updated_at")
    protected Instant updatedAt;

    @PrePersist
    void persist(){
        this.createdAt = Instant.now();
    }
}
