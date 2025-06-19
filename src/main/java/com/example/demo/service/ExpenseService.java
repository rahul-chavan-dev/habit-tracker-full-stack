package com.example.demo.service;

import com.example.demo.model.Expense;
import com.example.demo.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Get all expenses
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Get expense by ID
    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    // Add a new expense
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Update an existing expense
    public Expense updateExpense(Long id, Expense newExpense) {
        return expenseRepository.findById(id).map(expense -> {
            expense.setTitle(newExpense.getTitle());
            expense.setAmount(newExpense.getAmount());
            expense.setDate(newExpense.getDate());
            return expenseRepository.save(expense);
        }).orElseThrow(() -> new RuntimeException("Expense not found with id " + id));
    }

    // Delete an expense
    public void deleteExpense(Long id) {
        if (!expenseRepository.existsById(id)) {
            throw new RuntimeException("Expense not found with id " + id);
        }
        expenseRepository.deleteById(id);
    }
}
