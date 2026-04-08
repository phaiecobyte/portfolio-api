package com.phaiecobyte.portfolio_api.security.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "t_core_role")
@Getter
@Setter
public class TCoreRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="code", length = 50)
    private String code;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "t_core_role_permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "perm_id")
    )
    private Set<TCorePerm> permissions;
}
