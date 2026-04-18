package com.phaiecobyte.portfolio_api.module.pos.mapper;

import com.phaiecobyte.portfolio_api.module.pos.dto.req.ProductReq;
import com.phaiecobyte.portfolio_api.module.pos.dto.res.ProductRes;
import com.phaiecobyte.portfolio_api.module.pos.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "categoryId", target = "categories.id")
    @Mapping(target = "categories", ignore = true)
    Product toEntity(ProductReq dto);

    @Mapping(source = "categories.id", target = "categoryId")
    ProductReq toDto(Product entity);

    @Mapping(source = "categories.id", target = "categoryId")
    @Mapping(source = "categories.name", target = "categoryName")
    ProductRes toRes(Product entity);

    void updateEntity(@MappingTarget Product entity, ProductReq dto);
}
