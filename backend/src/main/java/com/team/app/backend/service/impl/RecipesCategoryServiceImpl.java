package com.team.app.backend.service.impl;

import com.team.app.backend.persistance.dao.IngredientsDao;
import com.team.app.backend.persistance.dao.RecipeCategoryDao;
import com.team.app.backend.persistance.model.Ingredient;
import com.team.app.backend.persistance.model.RecipeCategory;
import com.team.app.backend.service.IngredientsService;
import com.team.app.backend.service.RecipesCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecipesCategoryServiceImpl implements RecipesCategoryService {

    @Autowired
    private RecipeCategoryDao recipeCategoryDao;

    @Override
    public List<RecipeCategory> getAllCategoriess() {
        return recipeCategoryDao.getAll();
    }
}
