package com.phaiecobyte.portfolio_api.module.pos.model;

import com.phaiecobyte.portfolio_api.common.AuditField;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_post_payment")
@Getter
@Setter
public class Payment extends AuditField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "amount_tendered")
    private long amountTendered;
    @Column(name = "payment_method",length = 50)
    private String paymentMethod;
    @Column(name = "status", length = 10)
    private String status;

    @ManyToOne
    private Order order;
}
