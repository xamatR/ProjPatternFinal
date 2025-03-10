package com.example.proj.pathern;
// Strategy Pattern: Encapsulates different payment algorithms (cash or credit card) that can be interchanged easily.

public class CashPayment implements PaymentStrategy {
    @Override
    public String  pay(double amount) {
        return "Payment of R$" + amount + " in cash.";
    }
}

