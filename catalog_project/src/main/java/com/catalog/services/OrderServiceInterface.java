package com.catalog.services;

import com.catalog.entities.Order;
import com.catalog.models.OrderModel;

import java.util.List;

public interface OrderServiceInterface {

    Order insertOrder(OrderModel orderModel);
    Order getOrderById(Long orderId);
    List<OrderModel> getAllOrders();
    void deleteOrder(Long orderId);

}
