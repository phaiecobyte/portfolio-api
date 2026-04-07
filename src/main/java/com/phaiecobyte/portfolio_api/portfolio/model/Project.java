package com.phaiecobyte.portfolio_api.portfolio.model;

import com.phaiecobyte.portfolio_api.common.AuditField;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name ="tbl_project")
@Getter
@Setter
public class Project{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "description", length = 1000)
    private String description;

    @ElementCollection
    private List<String> tech;

    @ElementCollection
    private List<String> feature;

    @Column(name = "source_code_url", length = 500)
    private String sourceCodeUrl;

    @Column(name = "demo_video_url", length = 500)
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
