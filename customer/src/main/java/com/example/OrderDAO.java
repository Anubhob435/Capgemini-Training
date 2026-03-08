package com.example;

public interface OrderDAO {

    void updateOrder(Order order);

    Order fetchOrderById(int id);
}
