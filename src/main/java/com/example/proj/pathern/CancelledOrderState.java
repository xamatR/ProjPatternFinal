package com.example.proj.pathern;
// State Pattern: Manages the different states (New, Preparing, Ready, Served, Cancelled) of an Order and defines the transitions between these states.
public class CancelledOrderState implements OrderState {
    @Override
    public String next(Order order) {
        return "Pedido cancelado, sem próximo estado.";
    }

    @Override
    public String previous(Order order) {
        return  "Pedido cancelado, sem estado anterior.";
    }

    @Override
    public String getStatus() {
        return "Cancelled";
    }
}
