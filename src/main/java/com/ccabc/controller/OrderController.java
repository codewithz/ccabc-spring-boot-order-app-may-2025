package com.ccabc.controller;

import com.ccabc.model.Order;
import com.ccabc.payload.ApiSuccessPayload;
import com.ccabc.service.OrderService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<ApiSuccessPayload> placeOrder(@RequestBody Order order) {
        String result = orderService.placeOrder(order);
        HttpStatus status = HttpStatus.CREATED;
        ApiSuccessPayload apiSuccessPayload = ApiSuccessPayload.build(result, status, "Order Placed Successfully");
        return new ResponseEntity<>(apiSuccessPayload, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSuccessPayload> getOrderById(@Positive(message = "Negative Ids are not allowed") @PathVariable(name = "id") int id) {
        Order order = orderService.getOrderById(id);
        HttpStatus status = HttpStatus.OK;
        ApiSuccessPayload apiSuccessPayload = ApiSuccessPayload.build(order, status, "Order Found Successfully");
        return new ResponseEntity<>(apiSuccessPayload, status);
    }
}
