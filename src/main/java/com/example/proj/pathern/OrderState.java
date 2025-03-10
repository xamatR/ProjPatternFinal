package com.example.proj.pathern;
// State Pattern: Manages the different states (New, Preparing, Ready, Served, Cancelled) of an Order and defines the transitions between these states.

public interface OrderState {
    String next(Order order);
    String previous(Order order);
    String getStatus();
}
