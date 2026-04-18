package com.phaiecobyte.portfolio_api.module.pos.controller;

import com.phaiecobyte.portfolio_api.common.ApiResponse;
import com.phaiecobyte.portfolio_api.module.pos.dto.OrderDto;
import com.phaiecobyte.portfolio_api.module.pos.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pos/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody OrderDto req){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.apiSuccessRes(true,"Order successfully...!",orderService.createOrder(req))
                );
    }

    @GetMapping("/list")
    public ResponseEntity<Object> list(Pageable pageable){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.apiSuccessRes(true,"Retrieve order list successfully...!",orderService.list(pageable)));
    }

}
