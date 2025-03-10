package com.example.proj.pathern;

public class BasicBurger implements Dish {
    private String name;

    public BasicBurger(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return "Burger " + name;
    }

    @Override
    public double getPrice() {
        return 6.0;
    }

    @Override
    public String prepare() {
        return  "Preparing burger: " + name;
    }
}

