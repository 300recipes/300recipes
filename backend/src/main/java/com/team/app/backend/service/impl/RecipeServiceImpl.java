package com.team.app.backend.service.impl;

import com.team.app.backend.persistance.dao.RecipeDao;
import com.team.app.backend.persistance.dao.UserDao;
import com.team.app.backend.persistance.model.Recipe;
import com.team.app.backend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeDao recipeDao;


    @Override
    public void deleteRecipe(Long id) {
        recipeDao.delete(id);
    }

    @Override
    public void addRecipe() {

    }

    @Override
    public Recipe getRecipeById(Long id) {
        return recipeDao.get(id);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeDao.getAll();
    }
}
