package com.team.app.backend.persistance.dao.impl;

import com.team.app.backend.dto.IngredientDto;
import com.team.app.backend.persistance.dao.IngredientsDao;
import com.team.app.backend.persistance.dao.mappers.IngredientRowMapper;
import com.team.app.backend.persistance.dao.mappers.IngredientToRecipeRowMapper;
import com.team.app.backend.persistance.model.Ingredient;
import com.team.app.backend.persistance.model.IngredientToRecipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class IngredientsDaoImpl implements IngredientsDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private IngredientRowMapper ingredientRowMapper;

    @Autowired
    private IngredientToRecipeRowMapper ingredientToRecipeRowMapper;


    public IngredientsDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Ingredient> getAll() {
        return jdbcTemplate.query("SELECT id, name FROM ingredients",
                ingredientRowMapper);
    }

    @Override
    public List<IngredientToRecipe> getRecipes(long id) {
        return jdbcTemplate.query("SELECT ingrec.rec_id, ingrec.ingr_id, ingrec.measure, ingrec.amount, i.name FROM ingred_to_rec ingrec INNER JOIN ingredients i ON i.id = ingrec.ingr_id  where ingrec.rec_id = ?",
                new Object[]{id},
                ingredientToRecipeRowMapper);
    }

    @Override
    public void addRecipeIngred(long rec_id, List<IngredientDto> ingredients) {
        for (IngredientDto ingr:ingredients) {
            jdbcTemplate.update(
                    "INSERT INTO ingred_to_rec( rec_id, ingr_id, measure, amount) VALUES ( ?, ?, ?, ?)",
                    rec_id,
                    ingr.getId(),
                    ingr.getMeasure(),
                    ingr.getAmount()
            );
        }
    }
}
