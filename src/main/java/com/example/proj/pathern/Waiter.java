package com.example.proj.pathern;
// Observer Pattern: Allows Waiters (observers) to be notified automatically when an Order's state changes.

public class Waiter implements OrderObserver {
    private String name;

    public Waiter(String name) {
        this.name = name;
    }

    @Override
    public String update(Order order) {
        return "Waiter " + name + " notified: Order " + order.getId() + " is now " + order.getStatus();
    }
}
