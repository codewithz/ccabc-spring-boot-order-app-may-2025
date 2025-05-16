package com.ccabc.service;

import com.ccabc.model.Order;
import com.ccabc.model.OrderItem;
import com.ccabc.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

  public String placeOrder(Order order) {

      // Set the Order object inside each OrderItem
      if (order.getOrderItems() != null) {
          for (OrderItem item : order.getOrderItems()) {
              item.setOrder(order);  // this is key!
          }
      }
      Order placedOrder = orderRepository.save(order);
      if (placedOrder != null) {
          return "Order Placed Successfully";
      }
      return "Order Placement Failed";
  }

  public Order getOrderById(int orderId) {
      return orderRepository.findById(orderId).orElse(null);
  }
}
