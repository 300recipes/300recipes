package com.team.app.backend.persistance.dao;

import com.team.app.backend.persistance.model.RecipeStep;

import java.util.List;

public interface RecipeStepDao {

   List<RecipeStep> getAll();

   List<RecipeStep> getRecipes(long id);

}
