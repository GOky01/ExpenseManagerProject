package com.project.ExpenseManager.model;

import com.project.ExpenseManager.config.ExpensesModelConfigBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class ExpensesTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(ExpensesModelConfigBean.class);
    Expenses expenses = context.getBean("expenses",Expenses.class);
    @Test
    void testingModelCorresponding() {
        assertNotEquals((long)1,expenses.getId());
        assertNotEquals("milk",expenses.getProduct());
        assertNotEquals(10,expenses.getAmount());
        assertNotEquals("29-06-2021",expenses.getDate());
    }
}