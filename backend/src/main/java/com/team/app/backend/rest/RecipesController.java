package com.team.app.backend.rest;


import com.team.app.backend.persistance.model.Recipe;
import com.team.app.backend.persistance.model.RecipeWithContent;
import com.team.app.backend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class RecipesController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/recipes")
    public List<Recipe> findAllRecipes(){
        return recipeService.getAllRecipes();
    }


    @GetMapping("/recipes/{category}")
    public List<Recipe> findRecipesByCategory(@PathVariable("category") String category){
        return recipeService.getRecipesByCategory(category);
    }

    @GetMapping("/recipes/search/{searchStr}")
    public List<Recipe> findRecipesByString(@PathVariable("searchStr") String searchStr){
        return recipeService.searchByString(searchStr);
    }

    @GetMapping("/recipe/{id}")
    public RecipeWithContent findRecipe(@PathVariable("id") long id){
        return recipeService.getRecipeById(id);
    }

}
