package com.example.proj.pathern;
// Factory Method Pattern: Defines an interface for creating a Dish object and lets subclasses decide which class to instantiate.

public class TakeAwayOrderFactory implements OrderFactory {
    @Override
    public Order createOrder(int id) {
        return new TakeAwayOrder(id);
    }
}

