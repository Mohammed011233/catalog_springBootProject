package com.catalog.mappers;

import com.catalog.entities.Order;
import com.catalog.models.OrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface OrderMapper {

    @Mapping(source = "id" ,target = "orderId")
    @Mapping(source = "total" , target = "totalCost")
    @Mapping(source = "products" , target = "products")
    OrderModel toModelOrder(Order order);

    @Mapping(source = "orderId" ,target = "id")
    @Mapping(source = "totalCost" , target = "total")
    @Mapping(source = "products" , target = "products")
    Order toEntityOrder(OrderModel orderModel);
}
