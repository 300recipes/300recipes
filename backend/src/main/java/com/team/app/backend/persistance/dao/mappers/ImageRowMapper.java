package com.team.app.backend.persistance.dao.mappers;

import com.team.app.backend.persistance.model.Image;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ImageRowMapper implements RowMapper<Image> {

    @Override
    public Image mapRow(ResultSet resultSet, int rownumber) throws SQLException {
        return new Image(resultSet.getString("name"),
                resultSet.getBytes("image")

        );
    }
}