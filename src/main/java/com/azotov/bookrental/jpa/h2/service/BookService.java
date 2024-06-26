package com.azotov.bookrental.jpa.h2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azotov.bookrental.jpa.h2.repository.BookRepository;
import com.azotov.bookrental.jpa.h2.model.Book;
import com.azotov.bookrental.jpa.h2.dto.NewBookDto;
import jakarta.validation.*;


import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book registerBook(NewBookDto book) {
        Book newBook = new Book(book.getIsbn(), book.getTitle(), book.getAuthor());
        List<Book> booksFound = bookRepository.findByIsbn(book.getIsbn());
        if (booksFound.size() > 0) {
            Book bookSample = booksFound.get(0);
            if(!bookSample.equals(newBook)) {
                throw new RuntimeException("book can't be registered due ambiguous description");
            }
        }
        return bookRepository.save(newBook);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book borrowBook(Long bookId) throws Exception {
        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new Exception("Book not found"));
        if (book.isBorrowed()) {
            throw new Exception("Book already borrowed");
        }
        book.setBorrowed(true);
        return bookRepository.save(book);
    }

    public Book returnBook(Long bookId) throws Exception {
        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new ValidationException("Book not found"));
        book.setBorrowed(false);
        return bookRepository.save(book);
    }
}
