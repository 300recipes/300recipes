package com.team.app.backend.persistance.dao.impl;

import com.team.app.backend.persistance.dao.IngredientsDao;
import com.team.app.backend.persistance.dao.mappers.IngredientRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class IngredientsDaoImpl implements IngredientsDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private IngredientRowMapper ingredientRowMapper;

    public IngredientsDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

}
