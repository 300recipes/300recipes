package com.team.app.backend.persistance.dao;

import com.team.app.backend.persistance.model.RecipeCategory;

import java.util.List;

public interface RecipeCategoryDao {

    List<RecipeCategory> getAll();
}
