package com.azotov.bookrental.jpa.h2.controller;

import com.azotov.bookrental.jpa.h2.model.Book;
import com.azotov.bookrental.jpa.h2.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Book registerBook(@RequestBody Book book) {
        return bookService.registerBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/{bookId}/borrow")
    public Book borrowBook(@PathVariable Long bookId) throws Exception {
        return bookService.borrowBook(bookId);
    }

    @PostMapping("/{bookId}/return")
    public Book returnBook(@PathVariable Long bookId) throws Exception {
        return bookService.returnBook(bookId);
    }
}