package com.phaiecobyte.portfolio_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_experience")
@Data
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String position;
    private String startDate;
    private String endDate;
    @Max(5000)
    private String description;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
