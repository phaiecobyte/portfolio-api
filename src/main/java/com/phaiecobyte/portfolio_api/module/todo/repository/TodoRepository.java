package com.phaiecobyte.portfolio_api.module.todo.repository;

import com.phaiecobyte.portfolio_api.module.todo.entity.Todo;
import com.phaiecobyte.portfolio_api.module.todo.enums.TodoStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Page<Todo> findByStatus(TodoStatus status, Pageable pageable);
}
