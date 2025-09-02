package com.pransquare.dashboard.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pransquare.dashboard.entities.ExpenseMasterEntity;
import com.pransquare.dashboard.services.ExpenseMasterService;

@RestController
@RequestMapping("/Pransquare/MasterConfiguration/expense")
public class ExpenseMasterController {

    private ExpenseMasterService service;

    ExpenseMasterController(ExpenseMasterService expenseMasterService) {
        this.service = expenseMasterService;
    }

    @GetMapping
    public List<ExpenseMasterEntity> getAllExpenses() {
        return service.getAllExpenses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseMasterEntity> getExpenseById(@PathVariable int id) {
        return service.getExpenseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ExpenseMasterEntity createExpense(@RequestBody ExpenseMasterEntity expenseMaster) {
        return service.createExpense(expenseMaster);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseMasterEntity> updateExpense(
            @PathVariable int id,
            @RequestBody ExpenseMasterEntity expenseDetails) {
        try {
            return ResponseEntity.ok(service.updateExpense(id, expenseDetails));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable int id) {
        service.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
}
