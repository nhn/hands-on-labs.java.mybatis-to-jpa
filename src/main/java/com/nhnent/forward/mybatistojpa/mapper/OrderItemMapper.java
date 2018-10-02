package com.nhnent.forward.mybatistojpa.mapper;

import com.nhnent.forward.mybatistojpa.model.OrderItem;

public interface OrderItemMapper {
    int insertOrderItem(OrderItem orderItem);

    int deleteOrderItem(Long orderId);

}
