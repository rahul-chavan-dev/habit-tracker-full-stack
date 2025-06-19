package com.example.demo.controller;

import com.example.demo.model.Expense;
import com.example.demo.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "*") // Enable CORS for frontend access
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // GET all expenses
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    // GET expense by ID
    @GetMapping("/{id}")
    public Optional<Expense> getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    // POST new expense with validation
    @PostMapping
    public Expense addExpense(@Valid @RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    // PUT update expense with validation
    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @Valid @RequestBody Expense expense) {
        return expenseService.updateExpense(id, expense);
    }

    // DELETE expense
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }
}
