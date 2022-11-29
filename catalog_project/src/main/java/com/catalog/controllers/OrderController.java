package com.catalog.controllers;

import com.catalog.entities.Order;
import com.catalog.models.OrderModel;
import com.catalog.services.implementation.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("catalog/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("insert")
    public Order insertOrder( @RequestBody OrderModel orderModel){
        return orderService.insertOrder(orderModel);
    }

    @GetMapping("{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderService
                .getOrderById(id);
    }

    @GetMapping("")
    public List<OrderModel> getAllOrders(){
        return orderService
                .getAllOrders();
    }

    @DeleteMapping("delete/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService
                .deleteOrder(id);
    }

}
