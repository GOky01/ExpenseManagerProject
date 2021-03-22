package com.project.ExpenseManager.dto;

import com.project.ExpenseManager.model.Expenses;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ExpensesDTO extends Expenses {
    private Long id;
    private String date;
    private Integer amount;
    private String currency;
    private String product;
}



