package com.azotov.bookrental.jpa.h2.controller;

import com.azotov.bookrental.jpa.h2.model.Borrower;
import com.azotov.bookrental.jpa.h2.service.BorrowerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.*;

import java.util.*;

@RestController
@RequestMapping("/api/borrowers")
public class BorrowerController {
    @Autowired
    private BorrowerService borrowerService;

    @GetMapping
    public List<Borrower> getAllBorrowers() {
        return borrowerService.getAllBorrowers();
    }

    @PostMapping
    public Borrower registerBorrower(@RequestBody Borrower borrower) {
        return borrowerService.registerBorrower(borrower);
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
