package com.example.proj.pathern;
// Strategy Pattern: Encapsulates different payment algorithms (cash or credit card) that can be interchanged easily.

public interface PaymentStrategy {
    String pay(double amount);
}
