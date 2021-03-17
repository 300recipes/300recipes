package com.team.app.backend.persistance.dao.impl;

import com.team.app.backend.persistance.dao.RecipeCategoryDao;
import com.team.app.backend.persistance.dao.mappers.IngredientRowMapper;
import com.team.app.backend.persistance.dao.mappers.IngredientToRecipeRowMapper;
import com.team.app.backend.persistance.dao.mappers.RecipeCategoryRowMapper;
import com.team.app.backend.persistance.model.RecipeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class RecipeCategoryDaoImpl implements RecipeCategoryDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private RecipeCategoryRowMapper recipeCategoryRowMapper;


    public RecipeCategoryDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<RecipeCategory> getAll() {
        return jdbcTemplate.query("SELECT id, name FROM recipe_categories",
                recipeCategoryRowMapper);
    }
}
