package com.example.proj.pathern;
// Observer Pattern: Allows Waiters (observers) to be notified automatically when an Order's state changes.

public interface OrderObserver {
    String update(Order order);
}
