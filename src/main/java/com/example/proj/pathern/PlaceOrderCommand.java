package com.example.proj.pathern;
// Command Pattern: Encapsulates order actions (placing or canceling an order) as command objects, which can be executed by an invoker.

public class PlaceOrderCommand implements OrderCommand {
    private Order order;

    public PlaceOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public String execute() {
        return "Executing: Place order " + order.getId() + ". " + RestaurantManager.getInstance().addOrder(order);
    }
}

