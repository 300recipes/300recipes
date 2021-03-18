package com.team.app.backend.service;

import com.team.app.backend.dto.RecipeCreateDto;
import com.team.app.backend.dto.RecipeFilterDto;
import com.team.app.backend.persistance.model.Recipe;
import com.team.app.backend.persistance.model.RecipeWithContent;

import java.util.List;

public interface RecipeService {

    void deleteRecipe(Long id);

    void addRecipe(RecipeCreateDto recipeCreateDto);

    void approveRecipe(Long id);

    RecipeWithContent getRecipeById(Long id);

    List<Recipe> getRecipesByCategory(String category);

    List<Recipe> getAllRecipes();

    List<Recipe> searchByString(String searchStr);

    List<Recipe> findFilteredRecipe(RecipeFilterDto recipeFilterDto);
}
