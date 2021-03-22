package com.project.ExpenseManager.controller;

import com.project.ExpenseManager.dto.ExpensesDTO;
import com.project.ExpenseManager.dto.TotalDTO;
import com.project.ExpenseManager.model.CurrencyConversionBean;
import com.project.ExpenseManager.model.Expenses;
import com.project.ExpenseManager.service.ExpensesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class ExpensesController {
    @Autowired
    private ExpensesService ExpensesService;

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


    @GetMapping("/expenses")
    public Map<String, List<Expenses>> sortedExpenses(HttpServletResponse response) {
        try {
            ExpensesService ExpensesService = this.ExpensesService;
            response.setStatus(HttpServletResponse.SC_OK);
            return ExpensesService.sortedExpensesList();
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


    @GetMapping("/total")
    public TotalDTO expensesTotalByBase(@RequestParam String base, HttpServletResponse response) {
        try {
            response.setStatus(HttpServletResponse.SC_OK);
            return ExpensesService.expensesTotalByBase(base);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        return null;
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
                                                  @PathVariable BigDecimal quantity) {

        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("from", from);
        urlVariables.put("to", to);

        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
                urlVariables);

        CurrencyConversionBean response = responseEntity.getBody();

        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());
    }

}
