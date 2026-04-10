package com.phaiecobyte.portfolio_api.module.pos.mapper;

import com.phaiecobyte.portfolio_api.module.pos.dto.CategoryDto;
import com.phaiecobyte.portfolio_api.module.pos.dto.res.CategoryRes;
import com.phaiecobyte.portfolio_api.module.pos.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryDto dto);
    CategoryDto toDto(Category entity);
    CategoryRes toRes(Category entity);
    void updateEntity(@MappingTarget Category entity, CategoryDto dto);
}
