package com.phaiecobyte.portfolio_api.module.pos.model;

import com.phaiecobyte.portfolio_api.common.AuditField;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import static com.phaiecobyte.portfolio_api.common.Constants.STATUS_ACTIVE;

@Entity
@Table(name = "t_pos_product")
@Getter
@Setter
public class Product extends AuditField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "base_price")
    private long basePrice;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "status",length = 10)
    private String status = STATUS_ACTIVE;

    @ManyToOne
    private Category categories;

    @ManyToMany
    @JoinTable(
            name = "t_pos_prod_mod",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<ModifierGroup> modifierGroups;
}
