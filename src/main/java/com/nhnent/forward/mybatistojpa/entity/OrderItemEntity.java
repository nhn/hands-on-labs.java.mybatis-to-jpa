package com.nhnent.forward.mybatistojpa.entity;

import com.nhnent.forward.mybatistojpa.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "OrderItems")
public class OrderItemEntity {
    @EmbeddedId
    private Pk pk = new Pk();

    @Column
    private Integer quantity;


    @JoinColumn(name = "item_id")
    @ManyToOne
    private ItemEntity item;

    @JoinColumn(name = "order_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    private OrderEntity order;


    public OrderItem toOrderItemDto() {
        OrderItem orderItemDto = new OrderItem();
        orderItemDto.setOrderId(this.pk.getOrderId());
        orderItemDto.setLineNumber(this.pk.getLineNumber());
        orderItemDto.setQuantity(this.quantity);
        orderItemDto.setItem(this.item.toItemDto());

        return orderItemDto;
    }


    /*
     * Composite-id class must implement serializable.
     * Composite-id class must define equals and hashCode methods.
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "order_id")
        private Long orderId;

        @Column(name = "line_number")
        private Integer lineNumber;

    }

}
