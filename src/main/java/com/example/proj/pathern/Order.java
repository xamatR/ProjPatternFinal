package com.example.proj.pathern;

import java.util.ArrayList;
import java.util.List;
public abstract class Order {
    private int id;
    protected OrderState state;
    private List<OrderObserver> observers = new ArrayList<>();

    public Order(int id) {
        this.id = id;
        this.state = new NewOrderState();
    }

    public int getId() {
        return id;
    }

    public String setState(OrderState state) {
        this.state = state;
        return notifyObservers();
    }

    public String getStatus() {
        return state.getStatus();
    }

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    private String notifyObservers() {
        StringBuilder sb = new StringBuilder();
        for (OrderObserver observer : observers) {
            sb.append(observer.update(this)).append("\n");
        }
        return sb.toString().trim();
    }

    public OrderState getState() {
        return this.state;
    }
}

