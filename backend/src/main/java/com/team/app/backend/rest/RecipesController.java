package com.team.app.backend.rest;


import com.team.app.backend.persistance.model.Recipe;
import com.team.app.backend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8083", maxAge = 3600)
@RestController
@RequestMapping("api")
public class RecipesController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/recipes")
    public List<Recipe> findAllRecipes(){
        return recipeService.getAllRecipes();
    }

    @GetMapping("/recipe/{id}")
    public Recipe findRecipe(@PathVariable("id") long id){
        return recipeService.getRecipeById(id);
    }

}
