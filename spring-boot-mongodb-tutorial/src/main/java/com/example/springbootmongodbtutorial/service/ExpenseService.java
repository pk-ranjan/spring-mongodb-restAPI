package com.example.springbootmongodbtutorial.service;

import com.example.springbootmongodbtutorial.modal.Expense;
import com.example.springbootmongodbtutorial.repository.ExpenseRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {


  private final ExpenseRepository expenseRepository;


  public ExpenseService(ExpenseRepository expenseRepository) {
    this.expenseRepository = expenseRepository;
  }

  public void addExpense(Expense expense) {
    expenseRepository.insert(expense);
  }

  public void updateExpense(Expense expense) {
    Expense expense1 = expenseRepository.findById(expense.getId())
        .orElseThrow(() -> new RuntimeException(
            String.format("Cannot find expense by ID %s", expense.getId())));

    expense1.setExpenseName(expense.getExpenseName());
    expense1.setExpenseAmount(expense.getExpenseAmount());
    expense1.setExpenseCategory(expense.getExpenseCategory());

    expenseRepository.save(expense);

  }

  public List<Expense> getAllExpenses() {
    return expenseRepository.findAll();

  }

  public Expense getExpenseByName(String name) {
    return expenseRepository.findByName(name)
        .orElseThrow(
            () -> new RuntimeException(String.format("Cannot Find Expense by name %s", name)));
  }

  public void deleteExpense(String id ) {
    expenseRepository.deleteById(id);
  }

}
