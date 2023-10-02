package com.recipes.cookbook.controllers;

import com.recipes.cookbook.model.Recipe;
import com.recipes.cookbook.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RecipeController {

    private RecipeService recipeService = new RecipeService();

    @GetMapping("/recipes")
    public String listRecipes(Model model) {
        List<Recipe> recipes = recipeService.getAllRecipes();
        model.addAttribute("recipes", recipes);
        return "recipe/list";
    }

    @GetMapping("/recipes/{title}")
    public String viewRecipe(@PathVariable String title, Model model) {
        Recipe recipe = recipeService.getRecipeByTitle(title);
        model.addAttribute("recipe", recipe);
        return "recipe/view";
    }

    @GetMapping("/search")
    public String searchRecipes(@RequestParam("query") String query, Model model) {
        Recipe searchResult = recipeService.getRecipeByTitle(query);
        model.addAttribute("searchResult", searchResult);
        return "recipe/result";
    }

    @GetMapping("/recipes/add")
    public String recipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "recipe/form";
    }

    @PostMapping("/recipes/add")
    public String recipeSubmit(@ModelAttribute Recipe recipe) {
        recipeService.addRecipe(recipe);
        return "redirect:/recipes";
    }
}
