package com.team.app.backend.persistance.dao;

import com.team.app.backend.dto.RecipeCreateDto;
import com.team.app.backend.dto.RecipeFilterDto;
import com.team.app.backend.persistance.model.Recipe;
import com.team.app.backend.persistance.model.RecipeWithContent;

import java.util.List;

public interface RecipeDao {

    void add(Recipe recipe);

    void update(RecipeWithContent recipe);

    void delete(Long id);

    Recipe get(Long id);

    List<Recipe> getAll();

    List<Recipe> getRecipesByCategory(String category);

    List<Recipe> getRecipesBySearchStr(String searchStr);

    List<Recipe> findFilteredRecipe(RecipeFilterDto recipeFilterDto);

    void approve(Long id);


}
