package com.project.ExpenseManager.model;




import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.util.Objects;


@Component
@Entity
@Table(name = "expenses")
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer amount;
    private String date;
    private String product;
    public Expenses() {
    }
    public Expenses(Long id, Integer amount, String date, String product) {
        this.id=id;
        this.amount = amount;
        this.date = date;
        this.product = product;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expenses)) return false;
        Expenses expenses = (Expenses) o;
        return Objects.equals(getId(), expenses.getId()) && Objects.equals(getAmount(), expenses.getAmount()) && Objects.equals(getDate(), expenses.getDate()) && Objects.equals(getProduct(), expenses.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAmount(), getDate(), getProduct());
    }

}