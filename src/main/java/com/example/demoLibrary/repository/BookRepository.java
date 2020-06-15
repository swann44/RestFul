package com.example.demoLibrary.repository;

import com.example.demoLibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingOrDescriptionContaining(String searchTerm, String searchTerm1);
}
