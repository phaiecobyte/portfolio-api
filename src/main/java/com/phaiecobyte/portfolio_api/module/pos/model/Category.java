package com.phaiecobyte.portfolio_api.module.pos.model;

import com.phaiecobyte.portfolio_api.common.AuditField;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_pos_category")
@Getter
@Setter
public class Category extends AuditField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "description",length = 255)
    private String description;

    @Column(name = "status", length = 10)
    private String status;
}
