package com.team.app.backend.persistance.dao.mappers;

import com.team.app.backend.persistance.model.Ingredient;
import com.team.app.backend.persistance.model.RecipeStep;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class RecipeStepRowMapper implements RowMapper<RecipeStep> {

    @Override
    public RecipeStep mapRow(ResultSet resultSet, int rownumber) throws SQLException {
        return new RecipeStep((long) resultSet.getInt("id"),
                (long) resultSet.getInt("rec_id"),
                resultSet.getInt("order_num"),
                resultSet.getString("title"),
                resultSet.getString("description"),
                resultSet.getString("image_url")
        );
    }
}