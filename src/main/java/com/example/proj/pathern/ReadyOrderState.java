package com.example.proj.pathern;
// State Pattern: Manages the different states (New, Preparing, Ready, Served, Cancelled) of an Order and defines the transitions between these states.

public class ReadyOrderState implements OrderState {
    @Override
    public String next(Order order) {
        order.setState(new ServedOrderState());
        return "Transitioned from Ready to Served.";
    }

    @Override
    public String previous(Order order) {
        order.setState(new PreparingOrderState());
        return "Reverted from Ready to Preparing.";    }

    @Override
    public String getStatus() {
        return "Ready";
    }
}
