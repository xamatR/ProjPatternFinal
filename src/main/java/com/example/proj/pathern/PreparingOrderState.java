package com.example.proj.pathern;
// State Pattern: Manages the different states (New, Preparing, Ready, Served, Cancelled) of an Order and defines the transitions between these states.

public class PreparingOrderState implements OrderState {
    @Override
    public String next(Order order) {
        order.setState(new ReadyOrderState());
        return "Transitioned from Preparing to Ready.";
    }

    @Override
    public String previous(Order order) {
        order.setState(new NewOrderState());
        return "Reverted from Preparing to New.";
    }

    @Override
    public String getStatus() {
        return "Preparing";
    }
}

