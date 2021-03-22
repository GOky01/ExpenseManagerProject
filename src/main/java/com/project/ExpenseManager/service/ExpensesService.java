package com.project.ExpenseManager.service;


import com.project.ExpenseManager.dto.ExpensesDTO;
import com.project.ExpenseManager.dto.TotalDTO;
import com.project.ExpenseManager.model.Expenses;
import com.project.ExpenseManager.repository.ExpensesRepository;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        List<Expenses> unsortedlist = expensesList();

        Map<String, List<Expenses>> collect = unsortedlist.stream().sorted(Comparator.comparing(Expenses::getDate)).
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

    public TotalDTO expensesTotalByBase(String base) {

        List<Expenses> expensesList = expensesList();
        TotalDTO totalDTO = new TotalDTO();

        Integer sumOfBase = 0;
        for (Expenses expenses : expensesList) {

            if (expenses.getCurrency().equals(base)){
                sumOfBase += expenses.getAmount();}
        }
        totalDTO.setTotal(sumOfBase);
        totalDTO.setCurrency(base);
        return totalDTO;
    }
}
