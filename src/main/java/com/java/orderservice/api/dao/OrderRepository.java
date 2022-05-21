package com.java.orderservice.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.orderservice.api.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
