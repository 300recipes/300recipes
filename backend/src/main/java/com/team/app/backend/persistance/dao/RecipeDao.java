package com.team.app.backend.persistance.dao;

import com.team.app.backend.persistance.model.Recipe;
import java.util.List;

public interface RecipeDao {

    void add(Recipe recipe);

    void update(Recipe recipe);

    void delete(Long id);

    Recipe get(Long id);

    List<Recipe> getAll();

}
