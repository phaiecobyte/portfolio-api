package com.phaiecobyte.portfolio_api.todo.controller;

import com.phaiecobyte.portfolio_api.common.ApiResponse;
import com.phaiecobyte.portfolio_api.todo.dto.req.TodoCreateReq;
import com.phaiecobyte.portfolio_api.todo.dto.req.TodoUpdateReq;
import com.phaiecobyte.portfolio_api.todo.enums.TodoStatus;
import com.phaiecobyte.portfolio_api.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/list")
    public ResponseEntity<Object> getAll(
            @RequestParam(value = "status", required = false) TodoStatus status,
            Pageable pageable
    ){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.apiSuccessRes(true,"Retrieve todo list successfully...!",todoService.list(status,pageable)));
    }

    @GetMapping("/getById")
    public ResponseEntity<Object> getBy(
            @RequestParam(value = "id") UUID id
    ){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.apiSuccessRes(true,"Retrieve todo by id successfully", todoService.getById(id)));
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createTodo(@RequestBody TodoCreateReq req){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.apiSuccessRes(true,"Create todo successfully...!",todoService.create(req)));
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateTodo(@RequestParam(value = "id")UUID id , @RequestBody TodoUpdateReq req){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.apiSuccessRes(true,"Updated todo successfully...!",todoService.update(id,req)));
    }

    @PatchMapping("/updateStatus")
    public ResponseEntity<Object> updateStatus(
            @RequestParam(value = "id") UUID uuid,
            @RequestParam(value = "status") TodoStatus status){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.apiSuccessRes(true,"Change todo status successfully...!", todoService.changeStatus(uuid,status)));
    }

    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestParam(value = "id") UUID id){
        todoService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.apiSuccessRes(true,"Delete succesfully...!", null));
    }
}
