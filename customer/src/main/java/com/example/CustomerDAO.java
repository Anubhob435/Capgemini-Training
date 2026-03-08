package com.example;

import java.util.List;

public interface CustomerDAO {

    void insertCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(int id);

    Customer fetchCustomerById(int id);

    List<Customer> fetchAllCustomers();

    Customer fetchCustomerByEmail(String email);
}
