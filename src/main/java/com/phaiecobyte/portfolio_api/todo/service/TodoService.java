package com.phaiecobyte.portfolio_api.todo.service;

import com.phaiecobyte.portfolio_api.todo.dto.req.TodoCreateReq;
import com.phaiecobyte.portfolio_api.todo.dto.req.TodoUpdateReq;
import com.phaiecobyte.portfolio_api.todo.dto.res.TodoRes;
import com.phaiecobyte.portfolio_api.todo.enums.TodoStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TodoService {
    Page<TodoRes> list(TodoStatus status, Pageable pageable);
    TodoRes getById(UUID id);
    TodoRes create(TodoCreateReq req);
    TodoRes update(UUID id, TodoUpdateReq req);
    TodoRes changeStatus(UUID id, TodoStatus status);
    void delete(UUID id);
}
