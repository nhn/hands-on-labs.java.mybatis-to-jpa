package com.nhnent.forward.mybatistojpa.controller;

import com.nhnent.forward.mybatistojpa.model.Order;
import com.nhnent.forward.mybatistojpa.model.Page;
import com.nhnent.forward.mybatistojpa.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;


    @GetMapping("")
    public List<Order> getOrders(@RequestParam(defaultValue = "1") int page) {
        if (page < 1) {
            page = 1;
        }

        return orderService.getOrders(page, Page.PAGE_SIZE);
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable Long orderId) {
        return orderService.getOrder(orderId);
    }

}
