package com.phaiecobyte.portfolio_api.module.pos.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderReq {
    private String orderNumber;
    private long totalAmount;
    private String status;
}
