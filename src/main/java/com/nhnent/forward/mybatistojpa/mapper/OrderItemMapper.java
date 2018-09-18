package com.nhnent.forward.mybatistojpa.mapper;

import com.nhnent.forward.mybatistojpa.model.OrderItem;

import java.util.List;

public interface OrderItemMapper {
    List<OrderItem> getOrderItemsByOrderId(Long orderId);

}
