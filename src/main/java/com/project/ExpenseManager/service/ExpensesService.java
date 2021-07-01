package com.project.ExpenseManager.service;


import com.project.ExpenseManager.dto.ExpensesDTO;

import com.project.ExpenseManager.model.Expenses;
import com.project.ExpenseManager.repository.ExpensesRepository;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class ExpensesService {
    private final ExpensesRepository expensesRepository;
    private final ModelMapper modelMapper;

    public ExpensesService(ExpensesRepository expensesRepository, ModelMapper modelMapper) {
        this.expensesRepository = expensesRepository;
        this.modelMapper = modelMapper;
    }

    public Expenses postExpenses(ExpensesDTO expensesDTO) {
        Expenses expenses = new Expenses();

        modelMapper.map(expensesDTO, expenses);
        return expensesRepository.save(expenses);
    }


    public List<Expenses> expensesList() {
        return expensesRepository.findAll();
    }

    public Map<String, List<Expenses>> sortedExpensesList() {

        List<Expenses> sortedlist = expensesList();

        Map<String, List<Expenses>> collect = sortedlist.stream().sorted(Comparator.comparing(Expenses::getDate)).
                collect(Collectors.groupingBy(Expenses::getDate,LinkedHashMap::new, Collectors.toList()));

        return collect;
    }

    public List<Expenses> deleteExpensesByDate(String date) {
        List<Expenses> all = expensesRepository.findAll();
        ExpensesDTO expensesDTO = new ExpensesDTO();
        modelMapper.map(expensesDTO, all);
        List<Expenses> afterDel = new ArrayList<>();
        for (Expenses expenses : all) {
            if (expenses.getDate().equals(date)){
                expensesRepository.delete(expenses);
                afterDel.add(expenses);
            }
        }
        return afterDel;
    }
}
