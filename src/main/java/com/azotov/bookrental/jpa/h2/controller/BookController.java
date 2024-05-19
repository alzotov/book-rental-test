package com.azotov.bookrental.jpa.h2.controller;

import com.azotov.bookrental.jpa.h2.dto.NewBookDto;
import com.azotov.bookrental.jpa.h2.model.Book;
import com.azotov.bookrental.jpa.h2.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.*;
import jakarta.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Book registerBook(@Valid @RequestBody NewBookDto book) {
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }    
}