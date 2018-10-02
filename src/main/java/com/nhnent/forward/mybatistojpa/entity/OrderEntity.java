package com.nhnent.forward.mybatistojpa.entity;

import com.nhnent.forward.mybatistojpa.model.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "Orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date")
    private Date orderDate;

    @OneToMany(mappedBy = "order", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    List<OrderItemEntity> orderItems = new ArrayList<>();


    public Order toOrderDto() {
        Order orderDto = new Order();
        orderDto.setOrderId(this.orderId);
        orderDto.setOrderDate(this.orderDate);

        if (this.orderItems != null) {
            orderDto.setOrderItems(
                    this.orderItems.stream()
                                   .map(OrderItemEntity::toOrderItemDto)
                                   .collect(Collectors.toList())
                                  );
        }

        return orderDto;
    }

}
