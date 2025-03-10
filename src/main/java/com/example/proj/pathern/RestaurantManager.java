package com.example.proj.pathern;

import java.util.ArrayList;
import java.util.List;


// Singleton Pattern: Ensures that only one instance of RestaurantManager exists.
public class RestaurantManager {
    private static RestaurantManager instance;
    private List<Order> orders = new ArrayList<>();

    private RestaurantManager() {}

    public static synchronized RestaurantManager getInstance() {
        if (instance == null) {
            instance = new RestaurantManager();
        }
        return instance;
    }

    public String  addOrder(Order order) {
        orders.add(order);
        return "Order " + order.getId() + " added.";
    }

}
