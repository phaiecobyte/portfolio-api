package com.phaiecobyte.portfolio_api.portfolio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_profile")
@Getter
@Setter
public class Profile extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String position;
    @Max(1000)
    private String bio;

    @Lob
    private byte[] profileImage;
    private String profileImageType;
}
