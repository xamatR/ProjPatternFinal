package com.example.proj.pathern;
// Template Method Pattern: Defines the skeleton of a dish preparation algorithm (steps for preparing, cooking, plating), with some steps left for subclasses to implement.

public abstract class DishPreparationTemplate {
    public final String prepareDish() {
        StringBuilder sb = new StringBuilder();
        sb.append(prepareIngredients()).append("\n");
        sb.append(cook()).append("\n");
        sb.append(plate());
        return sb.toString();
    }

    protected abstract String prepareIngredients();
    protected abstract String cook();

    protected String plate() {
        return "Dish is being plated.";
    }
}

