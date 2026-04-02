package com.example.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class User {

    @NotEmpty(message = "Name required")
    private String name;

    @Email(message = "Invalid email")
    @NotEmpty(message = "Email required")
    private String email;

    @Min(value = 18, message = "Age must be 18+")
    private int age;

    public User() {
        // Default constructor (IMPORTANT)
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}