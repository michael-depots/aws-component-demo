package com.example.awscomponent.controller;

import com.example.awscomponent.entity.Customer;
import com.example.awscomponent.service.DynamoDBCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dynamodb")
public class DynamoDBCustomerController {

    @Autowired
    private DynamoDBCustomerService dynamoDBCustomerService;

    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return dynamoDBCustomerService.saveCustomer(customer);
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable("id") String customerId) {
        return dynamoDBCustomerService.getCustomerById(customerId);
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomerById(@PathVariable("id") String customerId) {
        return dynamoDBCustomerService.deleteCustomerById(customerId);
    }

    @PutMapping("/customer/{id}")
    public String updateCustomer(@PathVariable("id") String customerId, @RequestBody Customer customer) {
        return dynamoDBCustomerService.updateCustomer(customerId, customer);
    }
}
