package com.project.ExpenseManager.service;

import com.project.ExpenseManager.dto.CustomerDTO;
import com.project.ExpenseManager.model.Customer;
import com.project.ExpenseManager.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;

@Service
public class CustomerService {
    private final CustomerRepository userRepository;
    private final ModelMapper modelMapper;

    public CustomerService(CustomerRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public void ExpensesList() {
//        Customer customer = new Customer();
//        modelMapper.map(customerDTO, customer);
        userRepository.findAll();
    }

}
