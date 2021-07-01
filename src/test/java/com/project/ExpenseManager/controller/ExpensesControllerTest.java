package com.project.ExpenseManager.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;

@SpringBootTest
public class ExpensesControllerTest {

    @Autowired
    private ExpensesController expensesController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(expensesController).isNotNull();
    }

}