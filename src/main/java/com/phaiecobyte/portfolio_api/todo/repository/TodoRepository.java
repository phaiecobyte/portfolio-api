package com.phaiecobyte.portfolio_api.todo.repository;

import com.phaiecobyte.portfolio_api.todo.entity.Todo;
import com.phaiecobyte.portfolio_api.todo.enums.TodoStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Page<Todo> findByStatus(TodoStatus status, Pageable pageable);
}
