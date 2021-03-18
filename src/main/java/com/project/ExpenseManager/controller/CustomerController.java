package com.project.ExpenseManager.controller;

import com.project.ExpenseManager.model.Customer;
import com.project.ExpenseManager.repository.CustomerRepository;
import com.project.ExpenseManager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/customers")
@Controller
public class CustomerController {
    @Autowired
    private  CustomerService customerService;
//    @GetMapping("/")
//    public String hello(Model model) {
//        model.addAttribute("title", "Головна");
//        return "greeting";
//    }

    @GetMapping("/expenses")
    public void AllExpenses(Model model, HttpServletResponse response) {
        try {
            customerService.ExpensesList();
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
//    @PostMapping("/expenses")
//    public void AllExpenses(Model model, HttpServletResponse response) {
//        try {
//            customerService.ExpensesList();
//            response.setStatus(HttpServletResponse.SC_OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//        }
//    }
}
