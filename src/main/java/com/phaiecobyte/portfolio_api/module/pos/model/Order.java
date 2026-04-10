package com.phaiecobyte.portfolio_api.module.pos.model;

import com.phaiecobyte.portfolio_api.common.AuditField;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_pos_order")
@Getter
@Setter
public class Order extends AuditField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "order_numer",length = 50)
    private String orderNumber;

    @Column(name = "total_amount")
    private long totalAmount;

    @Column(name = "status", length = 10)
    private String status;
}
