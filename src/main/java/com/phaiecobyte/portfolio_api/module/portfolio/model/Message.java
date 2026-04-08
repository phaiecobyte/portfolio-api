package com.phaiecobyte.portfolio_api.portfolio.model;


import com.phaiecobyte.portfolio_api.common.AuditField;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "tbl_message")
@Data
public class Message extends AuditField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    @Column(length = 2000)
    private String content;
}
