package com.phaiecobyte.portfolio_api.module.pos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "t_pos_modifier")
@Entity
@Getter
@Setter
public class Modifier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "price_adjustment")
    private long priceAdjustment;

    @ManyToOne
    private ModifierGroup modifierGroup;
}
