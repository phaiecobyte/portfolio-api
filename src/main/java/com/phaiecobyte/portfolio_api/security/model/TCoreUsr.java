package com.phaiecobyte.portfolio_api.security.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "t_core_usr")
@Getter
@Setter
public class TCoreUsr {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "username", unique = true,length = 50)
    private String username;
    @Column(columnDefinition="text")
    private String password;
    @Column(name = "email", length = 30)
    private String email;

    @ManyToMany
    @JoinTable(
          name = "t_core_usr_role",
            joinColumns = @JoinColumn(name = "usr_id"),
            inverseJoinColumns = @JoinColumn (name = "role_id")
    )
    private Set<TCoreRole> roles;
}
