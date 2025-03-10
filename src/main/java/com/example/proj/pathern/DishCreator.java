package com.example.proj.pathern;

// Factory Method Pattern: Defines an interface for creating a Dish object and lets subclasses decide which class to instantiate.

public abstract class DishCreator {

    public abstract Dish createDish(String name);

    public void serveDish(String name) {
        Dish dish = createDish(name);
        dish.prepare();
        System.out.println("Serving: " + dish.getDescription());
    }
}
