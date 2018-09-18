package com.nhnent.forward.mybatistojpa.service;

import com.nhnent.forward.mybatistojpa.mapper.OrderMapper;
import com.nhnent.forward.mybatistojpa.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;


    public List<Order> getOrders(int pageNumber, int pageSize) {
        int totalCount = orderMapper.getOrderCount();

        int pageOffset = (pageNumber - 1) * pageSize;
        if (pageOffset >= totalCount) {
            return Collections.emptyList();
        }

        return orderMapper.getOrders(pageOffset, pageSize);
    }

    public Order getOrder(Long orderId) {
        return orderMapper.getOrder(orderId);
    }

}
