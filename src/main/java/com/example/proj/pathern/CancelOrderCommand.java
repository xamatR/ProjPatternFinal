package com.example.proj.pathern;

public class CancelOrderCommand implements OrderCommand {
    private Order order;

    public CancelOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public String execute() {
        String result = "Executing: Cancel order " + order.getId() + ".";
        result += order.setState(new CancelledOrderState());
        return result;
    }
}

