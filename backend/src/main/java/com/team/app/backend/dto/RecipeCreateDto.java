package com.team.app.backend.dto;

import com.team.app.backend.persistance.model.IngredientToRecipe;
import com.team.app.backend.persistance.model.RecipeStep;

import java.util.List;

public class RecipeCreateDto {
    String title;
    String description;
    String imageUrl;
    List<IngredientToRecipe> ingredients;
    List<RecipeStep> steps;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
