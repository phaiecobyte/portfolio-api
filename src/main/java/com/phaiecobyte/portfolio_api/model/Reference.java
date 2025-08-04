package com.phaiecobyte.portfolio_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_reference")
@Data
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phone;
    private String email;
    private String position;
    private String address;
}
