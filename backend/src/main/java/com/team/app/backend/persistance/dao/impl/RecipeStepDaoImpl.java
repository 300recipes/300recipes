package com.team.app.backend.persistance.dao.impl;

import com.team.app.backend.dto.IngredientDto;
import com.team.app.backend.dto.RecipeStepDto;
import com.team.app.backend.persistance.dao.RecipeStepDao;
import com.team.app.backend.persistance.dao.mappers.IngredientRowMapper;
import com.team.app.backend.persistance.dao.mappers.RecipeStepRowMapper;
import com.team.app.backend.persistance.model.Ingredient;
import com.team.app.backend.persistance.model.IngredientToRecipe;
import com.team.app.backend.persistance.model.RecipeStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class RecipeStepDaoImpl implements RecipeStepDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private RecipeStepRowMapper recipeStepRowMapper;

    public RecipeStepDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<RecipeStep> getAll() {
        return jdbcTemplate.query("SELECT id, rec_id, title, description, image_url, order_num FROM recipe_step",
                recipeStepRowMapper);
    }

    @Override
    public List<RecipeStep> getRecipes(long id) {
        return jdbcTemplate.query("SELECT id, rec_id, title, description, image_url, order_num FROM recipe_step where rec_id = ?",
                new Object[]{id},
                recipeStepRowMapper);
    }

    @Override
    public void addRecipeSteps(long rec_id, List<RecipeStepDto> stepDtos) {
        for (int i = 0; i < stepDtos.size(); i++) {
            RecipeStepDto stepDto = stepDtos.get(i);
            jdbcTemplate.update(
                    "INSERT INTO recipe_step( rec_id, title, description, image_url, order_num) VALUES ( ?, ?, ?, ?, ?)",
                    rec_id,
                    stepDto.getTitle(),
                    stepDto.getDescription(),
                    stepDto.getImageUrl(),
                    i);
        }
    }
}
