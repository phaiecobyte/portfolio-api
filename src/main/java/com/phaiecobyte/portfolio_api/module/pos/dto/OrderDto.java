package com.phaiecobyte.portfolio_api.module.pos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {
    private double totalAmount;
    private String orderNumber;
    private List<OrderItemDto> items;
}
