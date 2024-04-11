package com.zeyadaboushanab.orderservice.repository;

import com.zeyadaboushanab.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

