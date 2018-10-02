package com.nhnent.forward.mybatistojpa.service;

import com.nhnent.forward.mybatistojpa.entity.ItemEntity;
import com.nhnent.forward.mybatistojpa.entity.OrderEntity;
import com.nhnent.forward.mybatistojpa.entity.OrderItemEntity;
import com.nhnent.forward.mybatistojpa.model.Order;
import com.nhnent.forward.mybatistojpa.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;


    public List<Order> getOrders(Pageable pageable) {
        Page<OrderEntity> orderPage = orderRepository.findAll(pageable);

        return orderPage.getContent()
                        .stream()
                        .map(OrderEntity::toOrderDto)
                        .collect(Collectors.toList());
    }

    public Order getOrder(Long orderId) {
        return orderRepository.findOne(orderId).toOrderDto();
    }

    @Transactional
    public Order createOrder(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderDate(new Date());

        order.getOrderItems()
                .forEach(orderItem -> {
                    ItemEntity itemEntity = new ItemEntity();
                    itemEntity.setItemId(orderItem.getItem().getItemId());

                    OrderItemEntity orderItemEntity = new OrderItemEntity();
                    orderItemEntity.setOrder(orderEntity);
                    orderItemEntity.getPk().setLineNumber(orderItem.getLineNumber());
                    orderItemEntity.setItem(itemEntity);
                    orderItemEntity.setQuantity(orderItem.getQuantity());

                    orderEntity.getOrderItems().add(orderItemEntity);
                });

        return orderRepository.save(orderEntity).toOrderDto();
    }

    @Transactional
    public void deleteOrder(Long orderId) {
        orderRepository.delete(orderId);
    }

}
