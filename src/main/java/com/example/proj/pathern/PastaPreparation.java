package com.example.proj.pathern;
// Template Method Pattern: Defines the skeleton of a dish preparation algorithm (steps for preparing, cooking, plating), with some steps left for subclasses to implement.

public class PastaPreparation extends DishPreparationTemplate {
    @Override
    protected String prepareIngredients() {
        return "Boiling pasta and preparing the sauce.";
    }

    @Override
    protected String cook() {
        return "Mixing pasta and sauce.";
    }
}
