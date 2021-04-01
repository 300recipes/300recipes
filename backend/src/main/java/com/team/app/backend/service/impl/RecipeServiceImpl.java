package com.team.app.backend.service.impl;

import com.team.app.backend.dto.RecipeCreateDto;
import com.team.app.backend.dto.RecipeFilterDto;
import com.team.app.backend.persistance.dao.*;
import com.team.app.backend.persistance.model.Recipe;
import com.team.app.backend.persistance.model.RecipeCategory;
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

    @Autowired
    private RecipeCategoryDao recipeCategoryDao;

    @Override
    public void deleteRecipe(Long id) {
        recipeDao.delete(id);
    }

    @Override
    public void addRecipe(RecipeCreateDto recipeCreateDto,long user_id) {
        Recipe recipe = new Recipe();
        recipe.setTitle(recipeCreateDto.getTitle());
        recipe.setDescription(recipeCreateDto.getDescription());
        recipe.setImageUrl(recipeCreateDto.getImageUrl());
        long rec_id = recipeDao.add(recipe, user_id);
        ingredientsDao.addRecipeIngred(rec_id, recipeCreateDto.getIngredients());
        recipeStepDao.addRecipeSteps(rec_id, recipeCreateDto.getSteps());
        recipeCategoryDao.addRecipeCateg(rec_id, recipeCreateDto.getCategories());
    }

    @Override
    public void approveRecipe(Long id){
        recipeDao.approve(id);
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
    public List<Recipe> getNotApprovedRecipes() {
        return recipeDao.getNotApproved();
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
