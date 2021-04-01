package com.team.app.backend.persistance.dao;

import com.team.app.backend.dto.IngredientDto;
import com.team.app.backend.persistance.model.RecipeCategory;

import java.util.List;

public interface RecipeCategoryDao {

    List<RecipeCategory> getAll();

    void addRecipeCateg(long rec_id, List<Integer> categories) ;
}
