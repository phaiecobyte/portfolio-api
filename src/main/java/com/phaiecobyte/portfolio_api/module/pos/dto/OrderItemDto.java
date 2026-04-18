package com.phaiecobyte.portfolio_api.module.pos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {
    private long orderId;
    private long productId;
    private String name;
    private double unitPrice;
    private int qty;
    private String remark;
    private String fulfillmentStatus;
}
