package com.ccabc.repository;

import com.ccabc.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    // Custom query to find order items by order ID
    List<OrderItem> findByOrderId(int orderId);

    // Custom query to find order items by product ID
    List<OrderItem> findByProductId(int productId);
}
