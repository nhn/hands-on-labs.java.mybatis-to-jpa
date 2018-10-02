package com.nhnent.forward.mybatistojpa.mapper;

import com.nhnent.forward.mybatistojpa.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int getOrderCount();

    List<Order> getOrders(@Param("offset") int offset, @Param("limit") int limit);

    Order getOrder(Long orderId);

    int insertOrder(Order order);

    int deleteOrder(Long orderId);

}
