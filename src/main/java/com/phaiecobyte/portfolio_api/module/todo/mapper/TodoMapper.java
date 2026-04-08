package com.phaiecobyte.portfolio_api.module.todo.mapper;

import com.phaiecobyte.portfolio_api.module.todo.dto.req.TodoCreateReq;
import com.phaiecobyte.portfolio_api.module.todo.dto.req.TodoUpdateReq;
import com.phaiecobyte.portfolio_api.module.todo.dto.res.TodoRes;
import com.phaiecobyte.portfolio_api.module.todo.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo toEntity(TodoCreateReq dto);
    TodoRes toRes(Todo entity);
    void updateEntity(@MappingTarget Todo entity, TodoUpdateReq req);
}
