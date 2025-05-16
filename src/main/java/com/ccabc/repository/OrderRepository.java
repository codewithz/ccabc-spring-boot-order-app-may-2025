package com.ccabc.repository;

import com.ccabc.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    // Custom query to find orders by customer ID
    @Query("SELECT o FROM Order o WHERE o.customerId = :customerId")
    List<Order> findOrdersByCustomerId(@Param("customerId") int customerId);

    // Custom query to find orders by order status
    @Query("SELECT o FROM Order o WHERE o.orderStatus = :orderStatus")
    List<Order> findOrdersByOrderStatus(@Param("orderStatus") String orderStatus);
}
