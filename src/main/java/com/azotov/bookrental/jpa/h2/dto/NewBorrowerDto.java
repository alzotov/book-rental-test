package com.azotov.bookrental.jpa.h2.dto;

import jakarta.validation.constraints.*;

public class NewBorrowerDto {

    @NotEmpty
    private String name;

    @Email
    private String email;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
