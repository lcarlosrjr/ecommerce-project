package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.model.Order;
import com.ecommerce.orderservice.repository.OrderRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;
    private final AmqpTemplate amqpTemplate;

    public OrderServiceImpl(OrderRepository orderRepository, AmqpTemplate amqpTemplate) {
        this.orderRepository = orderRepository;
        this.amqpTemplate = amqpTemplate;
    }


    @Override
    public Order createOrder(Long productId, int quantity) {
        Order order = new Order();
        order.setProductId(productId);
        order.setQuantity(quantity);
        Order savedOrder = orderRepository.save(order);
        amqpTemplate.convertAndSend("order.exchange", "order.routingkey", savedOrder);
        return savedOrder;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public Order updateOrder(Long orderId, Order updatedOrder) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order existingOrder = optionalOrder.get();
            existingOrder.setProductId(updatedOrder.getProductId());
            existingOrder.setQuantity(updatedOrder.getQuantity());
            return orderRepository.save(existingOrder);
        } else {
            return null;
        }
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
