package com.team.app.backend.rest;


import com.team.app.backend.dto.RecipeCreateDto;
import com.team.app.backend.dto.RecipeFilterDto;
import com.team.app.backend.dto.UserRegistrationDto;
import com.team.app.backend.persistance.model.Recipe;
import com.team.app.backend.persistance.model.RecipeWithContent;
import com.team.app.backend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
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

    @PostMapping("/recipes/add")
    public ResponseEntity addRecipe(@RequestBody @Valid RecipeCreateDto recipeCreateDto){

        recipeService.addRecipe(recipeCreateDto);
        return ResponseEntity.ok().body("Recipe was successfully added");
    }

    @GetMapping("/recipes/{category}")
    public List<Recipe> findRecipesByCategory(@PathVariable("category") String category){
        return recipeService.getRecipesByCategory(category);
    }

    @PostMapping("/recipes/filter")
    public List<Recipe> findFilteredRecipe(@RequestBody @Valid RecipeFilterDto recipeFilterDto){
        return recipeService.findFilteredRecipe(recipeFilterDto);
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
