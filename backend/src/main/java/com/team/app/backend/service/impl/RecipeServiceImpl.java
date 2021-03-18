package com.team.app.backend.service.impl;

import com.team.app.backend.dto.RecipeCreateDto;
import com.team.app.backend.dto.RecipeFilterDto;
import com.team.app.backend.persistance.dao.IngredientsDao;
import com.team.app.backend.persistance.dao.RecipeDao;
import com.team.app.backend.persistance.dao.RecipeStepDao;
import com.team.app.backend.persistance.dao.UserDao;
import com.team.app.backend.persistance.model.Recipe;
import com.team.app.backend.persistance.model.RecipeWithContent;
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

    @Autowired
    private IngredientsDao ingredientsDao;

    @Autowired
    private RecipeStepDao recipeStepDao;

    @Override
    public void deleteRecipe(Long id) {
        recipeDao.delete(id);
    }

    @Override
    public void addRecipe(RecipeCreateDto recipeCreateDto) {
        //TODO: ADD
        RecipeWithContent recipe = new RecipeWithContent();
        recipe.setIngredients(recipeCreateDto.getIngredients());
        recipeDao.add(recipe);
    }

    @Override
    public RecipeWithContent getRecipeById(Long id) {
        return new RecipeWithContent(recipeDao.get(id),ingredientsDao.getRecipes(id),recipeStepDao.getRecipes(id));
    }

    @Override
    public List<Recipe> getRecipesByCategory(String category) {
        return recipeDao.getRecipesByCategory(category);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeDao.getAll();
    }

    @Override
    public List<Recipe> searchByString(String searchStr) {
        return recipeDao.getRecipesBySearchStr(searchStr);
    }

    @Override
    public List<Recipe> findFilteredRecipe(RecipeFilterDto recipeFilterDto) {
        return recipeDao.findFilteredRecipe(recipeFilterDto);
    }
}
