package com.team.app.backend.persistance.model;

public class Recipe {

    long id;
    String title;
    String description;
    String imageUrl;
    String author;


    int rating;

    public Recipe(Recipe recipe){
        this.id = recipe.getId();
        this.title = recipe.getTitle();
        this.description = recipe.getDescription();
        this.imageUrl = recipe.getImageUrl();
        this.author= recipe.getAuthor();
        this.rating = recipe.getRating();
    }
    public Recipe(long id, String title, String description,  String imageUrl, String author, int rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.author=author;
        this.rating = rating;
    }

    public Recipe() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
