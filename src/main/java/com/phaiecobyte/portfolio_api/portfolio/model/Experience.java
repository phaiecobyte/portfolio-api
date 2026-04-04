package com.phaiecobyte.portfolio_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_experience")
@Data
public class Experience extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String position;
    private String startDate;
    private String endDate;
    @Max(5000)
    private String description;

    public Experience(){}
    public Experience(String position, String startDate, String endDate, String description) {
        this.description = description;
        this.endDate = endDate;
        this.position = position;
        this.startDate = startDate;
    }
}
