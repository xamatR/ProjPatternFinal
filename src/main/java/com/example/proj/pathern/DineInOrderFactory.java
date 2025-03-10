package com.example.proj.pathern;

public class DineInOrderFactory implements OrderFactory {
    @Override
    public Order createOrder(int id) {
        return new DineInOrder(id);
    }
}
