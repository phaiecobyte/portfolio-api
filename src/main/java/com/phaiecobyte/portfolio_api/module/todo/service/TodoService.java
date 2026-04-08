package com.phaiecobyte.portfolio_api.module.todo.service;

import com.phaiecobyte.portfolio_api.module.todo.dto.req.TodoCreateReq;
import com.phaiecobyte.portfolio_api.module.todo.dto.req.TodoUpdateReq;
import com.phaiecobyte.portfolio_api.module.todo.dto.res.TodoRes;
import com.phaiecobyte.portfolio_api.module.todo.enums.TodoStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TodoService {
    Page<TodoRes> list(TodoStatus status, Pageable pageable);
    TodoRes getById(long id);
    TodoRes create(TodoCreateReq req);
    TodoRes update(long id, TodoUpdateReq req);
    TodoRes changeStatus(long id, TodoStatus status);
    void delete(long id);
}
