package com.phaiecobyte.portfolio_api.portfolio.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_education")
@Data
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "degree", length = 50)
    private String degree;
    @Column(name = "major", length = 50)
    private String major;
    @Column(name = "school", length = 50)
    private String school;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "address", length = 255)
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
