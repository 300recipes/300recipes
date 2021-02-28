package com.team.app.backend.persistance.dao.impl;

import com.team.app.backend.persistance.dao.RecipeDao;
import com.team.app.backend.persistance.dao.mappers.RecipeRowMapper;
import com.team.app.backend.persistance.dao.mappers.UserRowMapper;
import com.team.app.backend.persistance.model.Recipe;
import com.team.app.backend.persistance.model.RecipeWithContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class RecipeDaoImpl implements RecipeDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private RecipeRowMapper recipeRowMapper;


    public RecipeDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void add(Recipe recipe) {

    }

    @Override
    public void update(Recipe recipe) {

    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(
                "DELETE from recipes where id = ?",
                id
        );
    }

    @Override
    public Recipe get(Long id) {
        return jdbcTemplate.queryForObject("SELECT r.id,r.title,r.description,r.image,u.username author FROM recipes r INNER JOIN users u ON r.author_id = u.id WHERE r.id = ?",
                new Object[]{id},
                recipeRowMapper);
    }

    @Override
    public List<Recipe> getAll() {
        return jdbcTemplate.query("SELECT r.id,r.title,r.description,r.image,u.username author FROM recipes r INNER JOIN users u ON r.author_id = u.id",
                recipeRowMapper);
    }
}
