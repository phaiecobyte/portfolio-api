package com.phaiecobyte.portfolio_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_education")
@Data
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String degree;
    private String major;
    private String school;
    private String startDate;
    private String endDate;
    private String address;
}
