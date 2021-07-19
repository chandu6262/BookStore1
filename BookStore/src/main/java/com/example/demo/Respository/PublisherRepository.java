package com.example.demo.Respository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

}
