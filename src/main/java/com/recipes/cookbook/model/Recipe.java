package com.recipes.cookbook.model;

import lombok.Data;

import java.util.List;


@Data
public class Recipe {

    private String title;
    private String listOfIngredients;
    private String description;
    private String preparationSteps;
    private String cookingTime;

    public Recipe(String title, String listOfIngredients, String description, String preparationSteps, String cookingTime) {
        this.title = title;
        this.listOfIngredients = listOfIngredients;
        this.description = description;
        this.preparationSteps = preparationSteps;
        this.cookingTime = cookingTime;
    }

    public Recipe() {
    }
}
