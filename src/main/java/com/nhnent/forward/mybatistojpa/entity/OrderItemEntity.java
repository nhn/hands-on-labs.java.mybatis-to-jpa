package com.nhnent.forward.mybatistojpa.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
