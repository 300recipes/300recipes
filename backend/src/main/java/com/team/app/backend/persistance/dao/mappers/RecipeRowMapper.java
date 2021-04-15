package com.team.app.backend.persistance.dao.mappers;
import com.team.app.backend.persistance.model.Recipe;
import com.team.app.backend.persistance.model.Role;
import com.team.app.backend.persistance.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class RecipeRowMapper implements RowMapper<Recipe> {

    @Override
    public Recipe mapRow(ResultSet resultSet, int rownumber) throws SQLException {
        return new Recipe((long) resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getString("description"),
                resultSet.getString("image"),
                resultSet.getBytes("image_file"),
                resultSet.getString("author")
        );
    }
}