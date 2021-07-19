package com.example.demo.Respository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.RentedBooksDetails;

public interface RentedBooksDetailsRepository extends JpaRepository<RentedBooksDetails, Integer> {

}
