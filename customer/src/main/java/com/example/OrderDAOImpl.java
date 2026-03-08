package com.example;

import jakarta.persistence.*;

public class OrderDAOImpl implements OrderDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("customerPU");

    @Override
    public void updateOrder(Order order) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(order);
            em.getTransaction().commit();
            System.out.println("Order updated: " + order);
        } finally {
            em.close();
        }
    }

    @Override
    public Order fetchOrderById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Order.class, id);
        } finally {
            em.close();
        }
    }
}
