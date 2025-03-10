package com.example.proj.pathern;
// State Pattern: Manages the different states (New, Preparing, Ready, Served, Cancelled) of an Order and defines the transitions between these states.

public class NewOrderState implements OrderState {
    @Override
    public String next(Order order) {
        order.setState(new PreparingOrderState());
        return "Transitioned from New to Preparing.";
    }

    @Override
    public String previous(Order order) {
        return "Order is already in New state.";
    }

    @Override
    public String getStatus() {
        return "New";
    }
}

