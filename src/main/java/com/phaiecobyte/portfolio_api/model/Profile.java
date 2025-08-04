package com.phaiecobyte.portfolio_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.Data;

@Entity
@Table(name = "tbl_profile")
@Data
public class Profile {
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
