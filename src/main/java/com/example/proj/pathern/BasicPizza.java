package com.example.proj.pathern;

public class BasicPizza implements Dish {
    private String name;

    public BasicPizza(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return "Pizza " + name;
    }

    @Override
    public double getPrice() {
        return 8.0;
    }

    @Override
    public String prepare() {
        return  "Preparing pizza: " + name;
    }
}
