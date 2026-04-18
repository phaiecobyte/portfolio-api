package com.phaiecobyte.portfolio_api.module.pos.controller;

import com.phaiecobyte.portfolio_api.common.ApiResponse;
import com.phaiecobyte.portfolio_api.module.pos.dto.CategoryDto;
import com.phaiecobyte.portfolio_api.module.pos.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pos/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<Object> list(
            @RequestParam(value = "status", required = false) String status,
            Pageable pageable
    ){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.apiSuccessRes(true,"Retrieve category successfully...!",categoryService.list(status,pageable)));
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @RequestBody CategoryDto req){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.apiSuccessRes(true,"Create category successfully...!",categoryService.create(req)));
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestParam(value = "id") long id,@Valid @RequestBody CategoryDto req){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.apiSuccessRes(true,"Update category successfully...!", categoryService.update(id,req)));
    }

    @GetMapping("/getById")
    public ResponseEntity<Object> getById(@RequestParam(value = "id") long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.apiSuccessRes(true,"Retrieve category by id successfully...!", categoryService.getById(id)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(value = "id") long id){
        categoryService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.apiSuccessRes(true,"Delete category successfully...!",null));
    }
}
