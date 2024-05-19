package com.azotov.bookrental.jpa.h2.dto;

import jakarta.validation.constraints.*;


public class NewBookDto {
    @Pattern(regexp = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$", message="ISBN invalid")
    private String isbn;
    @NotEmpty
    private String title;
    @NotEmpty
    private String author;

    // Getters and setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
