package com.example;

import jakarta.persistence.*;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("customerPU");

    @Override
    public void insertCustomer(Customer customer) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            System.out.println("Customer inserted: " + customer);
        } finally {
            em.close();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(customer);
            em.getTransaction().commit();
            System.out.println("Customer updated: " + customer);
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteCustomer(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Customer customer = em.find(Customer.class, id);
            if (customer != null) {
                em.remove(customer);
                System.out.println("Customer deleted with id: " + id);
            } else {
                System.out.println("No customer found with id: " + id);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Customer fetchCustomerById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer customer = em.find(Customer.class, id);
            return customer;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Customer> fetchAllCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Customer fetchCustomerByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query = em.createQuery(
                    "SELECT c FROM Customer c WHERE c.email = :email", Customer.class);
            query.setParameter("email", email);
            return query.getSingleResult();
        } finally {
            em.close();
        }
    }
}
