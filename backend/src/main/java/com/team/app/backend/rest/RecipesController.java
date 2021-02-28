package com.team.app.backend.rest;


import com.team.app.backend.persistance.model.Recipe;
import com.team.app.backend.persistance.model.Role;
import com.team.app.backend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("api")
public class RecipesController {

    @Autowired
    RecipeService recipeService;

    @RolesAllowed(Role.USER)
    @GetMapping("/recipes")
    public List<Recipe> findAllRecipes(){
        return recipeService.getAllRecipes();
    }
}
