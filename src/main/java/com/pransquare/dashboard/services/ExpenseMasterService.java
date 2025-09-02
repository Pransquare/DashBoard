package com.pransquare.dashboard.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pransquare.dashboard.entities.ExpenseMasterEntity;
import com.pransquare.dashboard.repositories.ExpenseMasterRepository;

@Service
public class ExpenseMasterService {

    private ExpenseMasterRepository repository;

    ExpenseMasterService(ExpenseMasterRepository expenseMasterRepository) {
        this.repository = expenseMasterRepository;
    }

    public List<ExpenseMasterEntity> getAllExpenses() {
        return repository.findAll();
    }

    public Optional<ExpenseMasterEntity> getExpenseById(int id) {
        return repository.findById(id);
    }

    public ExpenseMasterEntity createExpense(ExpenseMasterEntity expenseMaster) {
        return repository.save(expenseMaster);
    }

    public ExpenseMasterEntity updateExpense(int id, ExpenseMasterEntity expenseDetails) {
        return repository.findById(id).map(expense -> {
            expense.setExpenseCode(expenseDetails.getExpenseCode());
            expense.setExpenseDesc(expenseDetails.getExpenseDesc());
            expense.setStatus(expenseDetails.getStatus());
            return repository.save(expense);
        }).orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
    }

    public void deleteExpense(int id) {
        repository.deleteById(id);
    }
}
