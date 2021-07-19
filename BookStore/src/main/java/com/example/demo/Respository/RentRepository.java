package com.example.demo.Respository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Rent;

public interface RentRepository extends JpaRepository<Rent, Integer> {

}
