package com.example.proj.pathern;
// Factory Method Pattern: Defines an interface for creating a Dish object and lets subclasses decide which class to instantiate.

public class PizzaCreator extends DishCreator {
    @Override
    public Dish createDish(String name) {
        return new BasicPizza(name);
    }
}
