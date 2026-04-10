package com.phaiecobyte.portfolio_api.module.pos.model;

import com.phaiecobyte.portfolio_api.common.AuditField;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_pos_modifier_group")
@Getter
@Setter
public class ModifierGroup extends AuditField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "is_required")
    private boolean isRequired;

    @Column(name = "max_selection")
    private int maxSelection;


}
