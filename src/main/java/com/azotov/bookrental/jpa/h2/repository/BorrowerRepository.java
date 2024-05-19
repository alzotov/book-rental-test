package com.azotov.bookrental.jpa.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azotov.bookrental.jpa.h2.model.Borrower;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {}
