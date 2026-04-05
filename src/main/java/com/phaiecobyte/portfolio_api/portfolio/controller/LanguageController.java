package com.phaiecobyte.portfolio_api.portfolio.controller;

import com.phaiecobyte.portfolio_api.portfolio.model.Language;
import com.phaiecobyte.portfolio_api.portfolio.service.impl.LanguageServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/language")
@RequiredArgsConstructor
public class LanguageController {
    private final LanguageServiceImpl service;
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
    public ResponseEntity<Object> create(@RequestBody Language req){
        return ResponseEntity.ok(service.create(req));
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable long id,
                                         @RequestBody Language req){
        return ResponseEntity.ok(service.update(id,req));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable long id){
        try {
            service.delete(id);
            return ResponseEntity.ok(Map.of("Message","Deleted Successfully"));
        }catch (Exception ex){
            log.error("An unexpected error occurred! +",ex);
            return null;
        }finally {
            log.info("Delete operation completed");
        }
    }

}
