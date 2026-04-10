package com.phaiecobyte.portfolio_api.module.pos.dto.res;

import com.phaiecobyte.portfolio_api.common.AuditFieldDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRes extends AuditFieldDto {
    private long id;
    private long categoryId;
    private String categoryName;
    private String name;
    private long basePrice;
    private String description;
}
