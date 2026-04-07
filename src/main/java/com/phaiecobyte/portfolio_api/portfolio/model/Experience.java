package com.phaiecobyte.portfolio_api.portfolio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tbl_experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "position", length = 50)
    private String position;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "description", length = 500)
    private String description;

    public Experience(){}
    public Experience(String position, String startDate, String endDate, String description) {
        this.description = description;
        this.endDate = endDate;
        this.position = position;
        this.startDate = startDate;
    }
}
