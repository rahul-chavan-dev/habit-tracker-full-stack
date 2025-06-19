package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotNull(message = "Amount is mandatory")
    @Positive(message = "Amount must be positive")
    private Double amount;  // Double so @NotNull works properly

    @NotNull(message = "Date is mandatory")
    @PastOrPresent(message = "Date cannot be in the future")
    private LocalDate date;

    // Constructors
    public Expense() {}

    public Expense(String title, Double amount, LocalDate date) {
        this.title = title;
        this.amount = amount;
        this.date = date;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
