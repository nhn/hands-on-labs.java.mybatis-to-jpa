package com.nhnent.forward.mybatistojpa.repository;

import com.nhnent.forward.mybatistojpa.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
