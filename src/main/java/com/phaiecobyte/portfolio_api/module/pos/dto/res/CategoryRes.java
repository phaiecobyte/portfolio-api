package com.phaiecobyte.portfolio_api.module.pos.dto.res;

import com.phaiecobyte.portfolio_api.common.AuditFieldDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRes extends AuditFieldDto {
    private long id;
    private String name;
    private String description;
    private String status;
}
