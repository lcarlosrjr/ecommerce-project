package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order createOrder(Long id, int quantity);
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Long orderId);
    Order updateOrder(Long orderId, Order updatedOrder);
    void deleteOrder(Long orderId);

}
