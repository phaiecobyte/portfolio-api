package com.phaiecobyte.portfolio_api.module.pos.service;

import com.phaiecobyte.portfolio_api.module.pos.dto.OrderDto;
import com.phaiecobyte.portfolio_api.module.pos.mapper.OrderMapper;
import com.phaiecobyte.portfolio_api.module.pos.model.Order;
import com.phaiecobyte.portfolio_api.module.pos.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Transactional
    public OrderDto createOrder(OrderDto dto){
        Order order = orderMapper.toEntity(dto);
        return orderMapper.toDto(orderRepository.save(order));
    }

    @Transactional
    public Page<OrderDto> list(Pageable pageable){
        Page<Order> orders = orderRepository.findAll(pageable);
        return orders.map(orderMapper::toDto);
    }

}
