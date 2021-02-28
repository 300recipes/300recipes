package com.team.app.backend.persistance.dao.mappers;

import com.team.app.backend.persistance.model.IngredientToRecipe;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class IngredientToRecipeRowMapper implements RowMapper<IngredientToRecipe> {

    @Override
    public IngredientToRecipe mapRow(ResultSet resultSet, int rownumber) throws SQLException {
        return new IngredientToRecipe((long) resultSet.getInt("rec_id"),
                (long) resultSet.getInt("ingr_id"),
                resultSet.getString("name"),
                resultSet.getString("measure"),
                resultSet.getString("amount")

        );
    }
}