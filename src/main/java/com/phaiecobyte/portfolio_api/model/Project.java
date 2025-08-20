package com.phaiecobyte.portfolio_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name ="tbl_project")
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @Max(1000)
    private String description;
    @ElementCollection
    private List<String> tech;
    @ElementCollection
    private List<String> feature;
    private String sourceCodeUrl;
    private String demoVideoUrl;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
