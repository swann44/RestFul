package com.example.demoLibrary.controller;


import com.example.demoLibrary.entity.Book;
import com.example.demoLibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRespository;
    @GetMapping("/books")
    public List<Book> index(){
        return bookRespository.findAll();
    }
    @GetMapping("/books/{id}")
    public Book show(@PathVariable Long id){
        return bookRespository.findById(id).get();
    }
    @PostMapping("/books/search")
    public List<Book> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return bookRespository.findByTitleContainingOrDescriptionContaining(searchTerm, searchTerm);
    }
    @PostMapping("/books")
    public Book create(@RequestBody Book book){
        return bookRespository.save(book);
    }
    @PutMapping("/books/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book){
        Book bookToUpdate = bookRespository.findById(id).get();
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setDescription(book.getDescription());
        return bookRespository.save(bookToUpdate);
    }
    @DeleteMapping("books/{id}")
    public boolean delete(@PathVariable Long id){
        bookRespository.deleteById(id);
        return true;
    }
}