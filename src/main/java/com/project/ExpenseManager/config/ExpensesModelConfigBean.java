package com.project.ExpenseManager.config;

import com.project.ExpenseManager.model.Expenses;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Expenses.class)
public class ExpensesModelConfigBean {
    @Bean
    public Expenses getInstance() {
        return new Expenses((long)1, 10, "29-06-2021" ,"milk");
    }
}