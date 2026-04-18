package com.phaiecobyte.portfolio_api.module.pos.mapper;

import com.phaiecobyte.portfolio_api.module.pos.dto.OrderDto;
import com.phaiecobyte.portfolio_api.module.pos.dto.OrderItemDto;
import com.phaiecobyte.portfolio_api.module.pos.model.Order;
import com.phaiecobyte.portfolio_api.module.pos.model.OrderItem;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    // --- ORDER MAPPINGS ---

    OrderDto toDto(Order entity);

    Order toEntity(OrderDto dto);

    // --- ORDER ITEM MAPPINGS ---

    @Mapping(source = "product.id", target = "productId")
    OrderItemDto toDto(OrderItem entity);

    @Mapping(source = "productId", target = "product.id")
    @Mapping(target = "order", ignore = true) // Ignored here, handled in @AfterMapping
    OrderItem toEntity(OrderItemDto dto);

    // --- BIDIRECTIONAL RELATIONSHIP HANDLING ---

    /**
     * When mapping an OrderDTO to an Order entity, MapStruct will map the list of items.
     * This @AfterMapping method ensures that each child OrderItem gets its 'order'
     * field set to the newly created parent Order, which is required by Hibernate
     * to save foreign keys correctly.
     */
    @AfterMapping
    default void linkOrderItems(@MappingTarget Order order) {
        if (order.getItems() != null) {
            for (OrderItem item : order.getItems()) {
                item.setOrder(order);
            }
        }
    }
}