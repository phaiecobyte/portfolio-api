package com.phaiecobyte.portfolio_api.controller;

import com.phaiecobyte.portfolio_api.model.Project;
import com.phaiecobyte.portfolio_api.service.ProjectService;
import com.phaiecobyte.portfolio_api.service.impl.ProjectServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectServiceImpl service;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/pagination")
    public ResponseEntity<Object> paged(Pageable pageable){
        return ResponseEntity.ok(service.paged(pageable));
    }
    @GetMapping("/id")
    public ResponseEntity<Object> getById(@RequestParam long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Project req){
        return ResponseEntity.ok(service.create(req));
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestParam long id, @RequestBody Project req){
        return ResponseEntity.ok(service.update(id, req));
    }

    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestParam long id){
        service.delete(id);
        return ResponseEntity.ok("Success");
    }

}
