package com.example.proj.pathern;
// Strategy Pattern: Encapsulates different payment algorithms (cash or credit card) that can be interchanged easily.

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String pay(double amount) {
        return "Payment of R$" + amount + " with card " + cardNumber + ".";
    }
}
