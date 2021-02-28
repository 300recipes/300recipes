package com.team.app.backend.service.impl;

import com.team.app.backend.persistance.dao.IngredientsDao;
import com.team.app.backend.persistance.model.Ingredient;
import com.team.app.backend.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IngredientsServiceImpl implements IngredientsService {

    @Autowired
    private IngredientsDao ingredientsDao;

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientsDao.getAll();
    }
}
