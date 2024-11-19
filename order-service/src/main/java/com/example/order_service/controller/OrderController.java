package com.example.order_service.controller;

import com.example.order_service.dao.entity.OrderEntity;
import com.example.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping()
    public List<OrderEntity> getAllOrders(){
        return service.getAllOrders();
    }

    @GetMapping("/{ordId}")
    public  OrderEntity getOrder(@PathVariable long ordId){
        return service.getOrder(ordId);
    }

    @PostMapping
    public  OrderEntity addOrder(@RequestBody OrderEntity orderEntity){
        return service.addOrder(orderEntity);
    }

    @GetMapping("/cust/{custId}")
    public List<OrderEntity> getOrdersOfCustomer(@PathVariable long custId){
        return service.getOrderByCustId(custId);
    }
}
