package com.phaiecobyte.portfolio_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_education")
@Data
public class Education extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String degree;
    private String major;
    private String school;
    private String startDate;
    private String endDate;
    private String address;

    public Education(){}
    public Education(String degree,String major, String school, String startDate,String endDate,String address) {
        this.address = address;
        this.degree = degree;
        this.endDate = endDate;
        this.major = major;
        this.school = school;
        this.startDate = startDate;
    }
}
