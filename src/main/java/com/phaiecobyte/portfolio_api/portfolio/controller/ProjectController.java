package com.phaiecobyte.portfolio_api.portfolio.controller;


import com.phaiecobyte.portfolio_api.portfolio.model.Project;
import com.phaiecobyte.portfolio_api.portfolio.service.impl.ProjectServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/v1/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectServiceImpl service;
    @GetMapping("/count")
    public long getCount() {
        return service.count();
    }
    @GetMapping
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/pagination")
    public ResponseEntity<Object> paged(Pageable pageable){
        return ResponseEntity.ok(service.paged(pageable));
    }
    @GetMapping("{id}")
    public ResponseEntity<Object> getById(@PathVariable long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Project req){
        return ResponseEntity.ok(service.create(req));
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable long id, @RequestBody Project req){
        return ResponseEntity.ok(service.update(id, req));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.ok(Map.of("Message","Deleted successfully"));
    }

}
