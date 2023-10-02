package com.recipes.cookbook.services;

import com.recipes.cookbook.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {
    private List<Recipe> book = new ArrayList<>();

    public RecipeService() {
        book.add(new Recipe("Tagliatelle", "flour, water, salt, egs", "easy", "mix all", "15 minutes"));
    }

    public List<Recipe> getAllRecipes() {
        return book;
    }

    public Recipe getRecipeByTitle(String title) {
        for (Recipe recipe : book) {
            if (recipe.getTitle().equalsIgnoreCase(title)) {
                return recipe;
            }
        }
        return book.get(0);
    }

    public void addRecipe(Recipe recipe) {
        book.add(recipe);
    }

}
