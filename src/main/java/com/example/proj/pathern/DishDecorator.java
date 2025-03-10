package com.example.proj.pathern;
// Decorator Pattern: Dynamically adds extra functionalities (e.g., extra cheese) to a Dish without altering its structure.

public abstract class DishDecorator implements Dish {
    protected Dish dish;

    public DishDecorator(Dish dish) {
        this.dish = dish;
    }

    @Override
    public String getDescription() {
        return dish.getDescription();
    }

    @Override
    public double getPrice() {
        return dish.getPrice();
    }

    @Override
    public String prepare() {
        dish.prepare();
        return "Preparing " + this.getDescription() + ".";
    }
}
