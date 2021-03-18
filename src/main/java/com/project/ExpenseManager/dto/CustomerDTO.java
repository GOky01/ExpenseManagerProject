package com.project.ExpenseManager.dto;

import com.project.ExpenseManager.model.Customer;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CustomerDTO extends Customer {
    private Long id;
    private String date;
    private Integer amount;
    private String currency;
    private String username;
}



