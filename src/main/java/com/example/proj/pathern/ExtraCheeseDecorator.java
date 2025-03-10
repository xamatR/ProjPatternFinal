package com.example.proj.pathern;
// Decorator Pattern: Dynamically adds extra functionalities (e.g., extra cheese) to a Dish without altering its structure.

public class ExtraCheeseDecorator extends DishDecorator {
    public ExtraCheeseDecorator(Dish dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return dish.getDescription() + " with extra cheese";
    }

    @Override
    public double getPrice() {
        return dish.getPrice() + 1.5;
    }
}
