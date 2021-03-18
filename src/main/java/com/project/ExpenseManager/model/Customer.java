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
//@Table(name = "Users")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    private Integer amount;
    private String currency;
    private String username;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getId().equals(customer.getId()) &&
                Objects.equals(getDate(), customer.getDate()) &&
                Objects.equals(getAmount(), customer.getAmount()) &&
                Objects.equals(getCurrency(), customer.getCurrency()) &&
                Objects.equals(getUsername(), customer.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getAmount(), getCurrency(), getUsername());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}