package com.phaiecobyte.portfolio_api.portfolio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name ="tbl_project")
@Data
public class Project extends BaseEntity{
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

    public Project(){}
    public Project(String name, List<String> tech ,String demoVideoUrl, String description, List<String> feature,  String sourceCodeUrl) {
        this.demoVideoUrl = demoVideoUrl;
        this.description = description;
        this.feature = feature;
        this.name = name;
        this.sourceCodeUrl = sourceCodeUrl;
        this.tech = tech;
    }
}
