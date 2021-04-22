package com.team.app.backend.rest;


import com.team.app.backend.config.security.jwt.JwtUtil;
import com.team.app.backend.dto.RecipeCreateDto;
import com.team.app.backend.dto.RecipeFilterDto;
import com.team.app.backend.dto.UserRegistrationDto;
import com.team.app.backend.persistance.model.Recipe;
import com.team.app.backend.persistance.model.RecipeWithContent;
import com.team.app.backend.persistance.model.Role;
import com.team.app.backend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "api")
public class RecipesController {

    @Autowired
    RecipeService recipeService;
    @Autowired
    JwtUtil jwtUtil;

    @GetMapping("/recipes")
    public List<Recipe> findAllRecipes(){ return recipeService.getAllRecipes(); }

    @PostMapping("/recipes/add")
    public ResponseEntity addRecipe(@RequestHeader HttpHeaders headers, @RequestBody RecipeCreateDto recipeCreateDto){
        System.out.println("add " + recipeCreateDto.getTitle());
        String userId = jwtUtil.getUserId(headers.getFirst(HttpHeaders.AUTHORIZATION).split(" ")[1]);
        recipeService.addRecipe(recipeCreateDto,Long.parseLong(userId));
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

    //@RolesAllowed(Role.ADMIN)
    @PostMapping("/recipe/approve/{id}")
    public void approveRecipe(@PathVariable("id") long id){
        recipeService.approveRecipe(id);
    }

    //@RolesAllowed(Role.ADMIN)
    @GetMapping("/recipes/notapproved")
    public List<Recipe> getNotApproved(){
        return recipeService.getNotApprovedRecipes();
    }

    @PostMapping(value = "/recipe/like/{id}")
    public void likeRecipe(@RequestHeader HttpHeaders headers, @PathVariable("id") long id){
        System.out.println("Like : " + headers.getFirst(HttpHeaders.AUTHORIZATION) );
        long user_id = Long.parseLong(jwtUtil.getUserId(headers.getFirst(HttpHeaders.AUTHORIZATION).split(" ")[1]));
        recipeService.likeRecipe(id,user_id,true);
    }

    @PostMapping("/recipe/dislike/{id}")
    public void dislikeRecipe(@RequestHeader HttpHeaders headers, @PathVariable("id") long id){
        System.out.println("Dislike : " + headers.getFirst(HttpHeaders.AUTHORIZATION) );
        long user_id = Long.parseLong(jwtUtil.getUserId(headers.getFirst(HttpHeaders.AUTHORIZATION).split(" ")[1]));
        recipeService.likeRecipe(id,user_id,false);
    }

}
