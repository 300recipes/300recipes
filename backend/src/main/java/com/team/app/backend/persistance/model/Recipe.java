package com.team.app.backend.persistance.model;

public class Recipe {

    long id;
    String title;
    String description;
    String content;
    String imageUrl;
    String author;

    public Recipe(long id, String title, String description, String content, String imageUrl, String author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.imageUrl = imageUrl;
        this.author=author;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

}
