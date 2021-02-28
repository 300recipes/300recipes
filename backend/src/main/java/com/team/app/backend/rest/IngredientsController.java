package com.team.app.backend.rest;

import com.team.app.backend.persistance.model.Ingredient;
import com.team.app.backend.persistance.model.Recipe;
import com.team.app.backend.service.IngredientsService;
import com.team.app.backend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class IngredientsController {


    @Autowired
    IngredientsService ingredientsService;

    @GetMapping("/ingredients")
    public List<Ingredient> findAllIngredients(){
        return ingredientsService.getAllIngredients();
    }



}
