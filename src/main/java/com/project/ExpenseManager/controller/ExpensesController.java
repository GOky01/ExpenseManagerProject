package com.project.ExpenseManager.controller;

import com.project.ExpenseManager.dto.ExpensesDTO;

import com.project.ExpenseManager.model.Expenses;
import com.project.ExpenseManager.service.ExpensesService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;

import java.util.*;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExpensesController {
    @Autowired
    private ExpensesService ExpensesService;

    @GetMapping("/expenses")
    public List<Expenses> expenses(HttpServletResponse response) {
        try {
            ExpensesService ExpensesService = this.ExpensesService;
            response.setStatus(HttpServletResponse.SC_OK);
            return ExpensesService.expensesList();
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        return null;
    }
//    @GetMapping("/expenses")
//    public Map<String, List<Expenses>> sortedExpenses(HttpServletResponse response) {
//        try {
//            ExpensesService ExpensesService = this.ExpensesService;
//            response.setStatus(HttpServletResponse.SC_OK);
//            return ExpensesService.sortedExpensesList();
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//        }
//        return null;
//    }
    @PostMapping("/expenses")
    public Expenses postExpenses(@RequestBody ExpensesDTO expensesDTO, HttpServletResponse response) {
        try {
            response.setStatus(HttpServletResponse.SC_CREATED);
            return ExpensesService.postExpenses(expensesDTO);

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        return null;
    }
    @DeleteMapping("/expenses")
    public List<Expenses> deleteExpensesByDate(@RequestParam String date, HttpServletResponse response) {
        try {
            response.setStatus(HttpServletResponse.SC_OK);
            return ExpensesService.deleteExpensesByDate(date);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        return null;
    }

}
