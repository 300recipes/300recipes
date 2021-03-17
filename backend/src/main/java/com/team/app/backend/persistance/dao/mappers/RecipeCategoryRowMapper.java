package com.team.app.backend.persistance.dao.mappers;

import com.team.app.backend.persistance.model.RecipeCategory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RecipeCategoryRowMapper implements RowMapper<RecipeCategory> {

    @Override
    public RecipeCategory mapRow(ResultSet resultSet, int rownumber) throws SQLException {
        return new RecipeCategory((long) resultSet.getInt("id"),
                resultSet.getString("name")
        );
    }
}