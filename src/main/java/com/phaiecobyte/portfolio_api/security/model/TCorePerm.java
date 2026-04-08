package com.phaiecobyte.portfolio_api.security.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_core_perm")
@Getter
@Setter
public class TCorePerm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "description", length = 500)
    private String description;
}
