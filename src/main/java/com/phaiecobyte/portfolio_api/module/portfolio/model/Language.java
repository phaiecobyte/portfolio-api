package com.phaiecobyte.portfolio_api.module.portfolio.model;

import com.phaiecobyte.portfolio_api.common.AuditField;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String icon;
    private int level;

    public Language(){}
    public Language(String name,int level, String icon) {
        this.icon = icon;
        this.level = level;
        this.name = name;
    }
}
