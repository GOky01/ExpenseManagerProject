package com.project.ExpenseManager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "expenses")
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer amount;
    private String currency;
    private String date;
    private String product;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expenses)) return false;
        Expenses expenses = (Expenses) o;
        return getId().equals(expenses.getId()) &&
                Objects.equals(getDate(), expenses.getDate()) &&
                Objects.equals(getAmount(), expenses.getAmount()) &&
                Objects.equals(getCurrency(), expenses.getCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getAmount(), getCurrency());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}