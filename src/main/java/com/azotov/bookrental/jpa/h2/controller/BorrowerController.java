package com.azotov.bookrental.jpa.h2.controller;

import com.azotov.bookrental.jpa.h2.model.Borrower;
import com.azotov.bookrental.jpa.h2.service.BorrowerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
