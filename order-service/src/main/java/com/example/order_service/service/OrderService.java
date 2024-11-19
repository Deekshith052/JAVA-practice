package com.example.order_service.service;

import com.example.order_service.dao.entity.OrderEntity;
import com.example.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repo;

    public List<OrderEntity> getAllOrders(){
        return repo.findAll();
    }

    public OrderEntity getOrder(long OrdId){
        Optional<OrderEntity> orderEntity=repo.findById(OrdId);
        if (orderEntity.isPresent()){
            return orderEntity.get();
        }
        else
            return null;
    }

    public OrderEntity addOrder(OrderEntity orderEntity){
        return repo.saveAndFlush(orderEntity);
    }

    public  List<OrderEntity> getOrderByCustId(long custId){
        return repo.findByCustId(custId);
    }
}
