package com.team.app.backend.persistance.model;

public class IngredientToRecipe {
    long recipeId;
    long ingredientId;
    String measure;
    String amount;

    public IngredientToRecipe(long recipeId, long ingredientId, String measure, String amount) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.measure = measure;
        this.amount = amount;
    }

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }

    public long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
