package com.example;

import java.time.LocalDate;
import java.util.List;

public class App {

    public static void main(String[] args) {

        CustomerDAO customerDAO = new CustomerDAOImpl();
        OrderDAO orderDAO = new OrderDAOImpl();

        // Insert

        System.out.println("\n--- INSERT Customer with Order ---");
        Customer customer = new Customer(
                "Alice Johnson",
                "alice@example.com",
                "Female",
                9876543210L,
                LocalDate.of(2024, 1, 15));

        Order order = new Order(
                "ORD-001",
                "Laptop",
                1,
                75000.00,
                LocalDate.of(2024, 1, 16));

        order.setCustomer(customer);
        customer.setOrder(order);

        customerDAO.insertCustomer(customer);

        // Fetch customer by ID

        System.out.println("\n--- FETCH Customer by ID ---");
        int savedId = customer.getId();
        Customer fetched = customerDAO.fetchCustomerById(savedId);
        System.out.println("Fetched: " + fetched);

        // Update

        System.out.println("\n--- UPDATE Customer ---");
        fetched.setCustomerName("Alice Smith");
        fetched.setPhone(9000000001L);
        customerDAO.updateCustomer(fetched);

        // Fetch All Customers

        System.out.println("\n--- FETCH ALL Customers ---");
        List<Customer> allCustomers = customerDAO.fetchAllCustomers();
        allCustomers.forEach(System.out::println);

        // Fetch by Email

        System.out.println("\n--- FETCH Customer by Email ---");
        Customer byEmail = customerDAO.fetchCustomerByEmail("alice@example.com");
        System.out.println("Found by email: " + byEmail);

        // Fetch by ID and update

        System.out.println("\n--- FETCH Order by ID ---");
        int orderId = fetched.getOrder() != null ? fetched.getOrder().getId() : 1;
        Order fetchedOrder = orderDAO.fetchOrderById(orderId);
        System.out.println("Fetched Order: " + fetchedOrder);

        System.out.println("\n--- UPDATE Order ---");
        if (fetchedOrder != null) {
            fetchedOrder.setQuantity(2);
            fetchedOrder.setPrice(70000.00);
            orderDAO.updateOrder(fetchedOrder);
        }

        // Delete By ID

        System.out.println("\n--- DELETE Customer by ID ---");
        customerDAO.deleteCustomer(savedId);

        System.out.println("\nAll operations completed successfully.");
    }
}
