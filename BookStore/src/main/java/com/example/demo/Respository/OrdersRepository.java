package com.example.demo.Respository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
