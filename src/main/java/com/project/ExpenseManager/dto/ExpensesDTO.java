package com.project.ExpenseManager.dto;

import com.project.ExpenseManager.model.Expenses;

import java.util.List;

public class ExpensesDTO extends Expenses {
    private Long id;
    private String date;
    private Integer amount;
    private String product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}



