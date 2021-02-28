package com.team.app.backend.persistance.model;

import java.util.List;

public class RecipeWithContent extends Recipe {
    List<IngredientToRecipe> ingredients;
    List<RecipeStep> steps;

    public RecipeWithContent(Recipe recipe, List<IngredientToRecipe> ingredients, List<RecipeStep> steps) {
        super(recipe);
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public RecipeWithContent(List<IngredientToRecipe> ingredients, List<RecipeStep> steps) {
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public RecipeWithContent() {

    }

    public List<IngredientToRecipe> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientToRecipe> ingredients) {
        this.ingredients = ingredients;
    }

    public List<RecipeStep> getSteps() {
        return steps;
    }

    public void setSteps(List<RecipeStep> steps) {
        this.steps = steps;
    }
}
