package com.team.app.backend.dto;

public class IngredientDto {
    Integer id;
    String measure;
    Integer amount;

    public IngredientDto(Integer id, String measure, Integer amount) {
        this.id = id;
        this.measure = measure;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
