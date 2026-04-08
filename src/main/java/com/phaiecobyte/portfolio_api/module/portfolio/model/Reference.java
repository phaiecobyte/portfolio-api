package com.phaiecobyte.portfolio_api.module.portfolio.model;

import com.phaiecobyte.portfolio_api.common.AuditField;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_reference")
@Data
public class Reference{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phone;
    private String email;
    private String position;
    private String address;

    public Reference(){}
    public Reference(String name,String position,String address, String email,String phone) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.position = position;
    }
}
