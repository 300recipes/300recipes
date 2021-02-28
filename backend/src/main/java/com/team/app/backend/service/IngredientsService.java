package com.team.app.backend.service;


import com.team.app.backend.persistance.model.Ingredient;

import java.util.List;

public interface IngredientsService {

    List<Ingredient> getAllIngredients();
}
