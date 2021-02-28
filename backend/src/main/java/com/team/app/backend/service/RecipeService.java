package com.team.app.backend.service;

import com.team.app.backend.persistance.model.Recipe;

import java.util.List;

public interface RecipeService {

    void deleteRecipe(Long id);

    void addRecipe();

    Recipe getRecipeById(Long id);

    List<Recipe> getAllRecipes();
}
