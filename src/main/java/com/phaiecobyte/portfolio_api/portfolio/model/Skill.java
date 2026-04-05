package com.phaiecobyte.portfolio_api.portfolio.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_skill",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_skill", columnNames = "name"
        )
)
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String icon;
    private int level;

    public Skill(){}
    public Skill(String name, int level, String icon) {
        this.name = name;
        this.level = level;
        this.icon = icon;
    }

}
