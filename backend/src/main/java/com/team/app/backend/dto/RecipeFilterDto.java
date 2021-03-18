package com.team.app.backend.dto;

import java.util.List;

public class RecipeFilterDto {

    String query;
    List<String> ingredients;
    List<String> category;

    public RecipeFilterDto(String query, List<String> ingredients, List<String> category) {
        this.query = query;
        this.ingredients = ingredients;
        this.category = category;
    }

    public RecipeFilterDto() {
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "RecipeFilterDto{" +
                "query='" + query + '\'' +
                ", ingredients=" + ingredients.toString() +
                ", category=" + category.toString() +
                '}';
    }
}
