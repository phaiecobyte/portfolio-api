package com.phaiecobyte.portfolio_api.module.pos.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductReq {
    private long categoryId;
    private String name;
    private long basePrice;
    private String description;
}
