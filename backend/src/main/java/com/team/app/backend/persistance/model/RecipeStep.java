package com.team.app.backend.persistance.model;

public class RecipeStep {
    long id;
    long recipeId;
    int orderNumber;
    String title;
    String description;
    String imageUrl;

    public RecipeStep(long id, long recipeId, int orderNumber, String title, String description, String imageUrl) {
        this.id = id;
        this.recipeId = recipeId;
        this.orderNumber = orderNumber;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public RecipeStep() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
