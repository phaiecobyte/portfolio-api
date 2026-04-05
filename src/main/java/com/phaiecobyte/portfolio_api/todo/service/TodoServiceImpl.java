package com.phaiecobyte.portfolio_api.todo.service;

import com.phaiecobyte.portfolio_api.todo.dto.req.TodoCreateReq;
import com.phaiecobyte.portfolio_api.todo.dto.req.TodoUpdateReq;
import com.phaiecobyte.portfolio_api.todo.dto.res.TodoRes;
import com.phaiecobyte.portfolio_api.todo.entity.Todo;
import com.phaiecobyte.portfolio_api.todo.enums.TodoStatus;
import com.phaiecobyte.portfolio_api.todo.mapper.TodoMapper;
import com.phaiecobyte.portfolio_api.todo.repository.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    @Override
    public Page<TodoRes> list(TodoStatus status,Pageable pageable){
        Page<Todo> page;
        if(status != null){
            page = todoRepository.findByStatus(status,pageable);
        }else{
            page = todoRepository.findAll(pageable);
        }

        return page.map(todoMapper::toRes);
    }

    @Override
    public TodoRes getById(UUID id) {
        Todo entity = todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo not found with id: " + id));
        return todoMapper.toRes(entity);
    }

    @Override
    public TodoRes create(TodoCreateReq req) {
        Todo entity = todoMapper.toEntity(req);
        if(entity.getStatus() == TodoStatus.DONE && entity.getCompletedAt() == null){
            entity.setCompletedAt(LocalDateTime.now());
        }

        Todo saved = todoRepository.save(entity);

        return todoMapper.toRes(saved);
    }

    @Override
    public TodoRes update(UUID id, TodoUpdateReq req){
        Todo entity = todoRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Todo not found with id:"+id));

        todoMapper.updateEntity(entity,req);
        applyStatusLogic(entity);
        Todo updated = todoRepository.save(entity);

        return todoMapper.toRes(updated);
    }

    @Override
    public void delete(UUID id) {
        Todo entity = todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo not found with id: " + id));
        todoRepository.delete(entity);
    }

    @Override
    public TodoRes changeStatus(UUID id, TodoStatus status) {
        Todo entity = todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo not found with id: " + id));

        entity.setStatus(status);

        if (status == TodoStatus.DONE) {
            entity.setCompletedAt(LocalDateTime.now());
            if (entity.getProgressPercent() == null || entity.getProgressPercent() < 100) {
                entity.setProgressPercent(100);
            }
        } else if (status == TodoStatus.TODO || status == TodoStatus.IN_PROGRESS) {
            entity.setCompletedAt(null);
        }

        Todo updated = todoRepository.save(entity);
        return todoMapper.toRes(updated);
    }
    //=========================== Helper Methods ==========================
    private void applyStatusLogic(Todo entity){
        if(entity.getStatus() == TodoStatus.DONE){
            if(entity.getCompletedAt() == null){
                entity.setCompletedAt(LocalDateTime.now());
            }
            if(entity.getProgressPercent() == null || entity.getProgressPercent() < 100 ){
                entity.setProgressPercent(100);
            }
        }else if(entity.getStatus() == TodoStatus.TODO || entity.getStatus() == TodoStatus.IN_PROGRESS){
            entity.setCompletedAt(null);
        }
    }
}
