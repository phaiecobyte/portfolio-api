package com.phaiecobyte.portfolio_api.module.pos.model;

import com.phaiecobyte.portfolio_api.common.AuditField;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "t_pos_order_item")
@Getter
@Setter
public class OrderItem extends AuditField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "qty")
    private int qty;

    @Column(name = "unit_price")
    private long unitPrice;

    @Column(name = "fulfillment_status",length = 10)
    private String fulfillmentStatus;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private String appliedModifiers;

    @Column(name = "remark", length = 50)
    private String remark;

    @ManyToOne
    private Order order;
    @ManyToOne
    private Product product;
}
