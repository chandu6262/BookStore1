package com.example.demo.Respository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Books;

public interface BooksRepository extends JpaRepository<Books, Integer> {

}
