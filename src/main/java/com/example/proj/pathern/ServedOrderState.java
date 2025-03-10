package com.example.proj.pathern;
// State Pattern: Manages the different states (New, Preparing, Ready, Served, Cancelled) of an Order and defines the transitions between these states.

public class ServedOrderState implements OrderState {
    @Override
    public String next(Order order) {
        return  "The order has already been served.";
    }

    @Override
    public String previous(Order order) {
        order.setState(new ReadyOrderState());
        return "Reverted from Served to Ready.";
    }

    @Override
    public String getStatus() {
        return "Served";
    }
}
