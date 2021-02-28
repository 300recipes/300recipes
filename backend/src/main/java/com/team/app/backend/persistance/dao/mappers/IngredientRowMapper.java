package com.team.app.backend.persistance.dao.mappers;

import com.team.app.backend.persistance.model.Ingredient;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class IngredientRowMapper implements RowMapper<Ingredient> {

    @Override
    public Ingredient mapRow(ResultSet resultSet, int rownumber) throws SQLException {
        return new Ingredient((long) resultSet.getInt("id"),
                resultSet.getString("name")
        );
    }
}