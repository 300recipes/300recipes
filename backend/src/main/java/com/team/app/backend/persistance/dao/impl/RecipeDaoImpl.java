package com.team.app.backend.persistance.dao.impl;

import com.team.app.backend.dto.RecipeCreateDto;
import com.team.app.backend.dto.RecipeFilterDto;
import com.team.app.backend.persistance.dao.RecipeDao;
import com.team.app.backend.persistance.dao.mappers.RecipeRowMapper;
import com.team.app.backend.persistance.dao.mappers.UserRowMapper;
import com.team.app.backend.persistance.model.Recipe;
import com.team.app.backend.persistance.model.RecipeWithContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
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
    public void update(RecipeWithContent recipe) {

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

    @Override
    public List<Recipe> getRecipesByCategory(String category) {
        return jdbcTemplate.query("SELECT DISTINCT(r.id),r.title,r.description,r.image,u.username author FROM recipes r INNER JOIN users u ON r.author_id = u.id INNER JOIN rec_to_categ rtc ON r.id = rtc.rec_id INNER JOIN recipe_categories cat ON cat.id = rtc.cat_id where cat.name = ?",
                new Object[] { category },
                recipeRowMapper);    }

    @Override
    public List<Recipe> getRecipesBySearchStr(String searchStr) {

        searchStr="%"+searchStr+"%";

        return jdbcTemplate.query("SELECT DISTINCT(r.id),r.title,r.description,r.image,u.username author FROM recipes r INNER JOIN users u ON r.author_id = u.id WHERE LOWER(r.title) like ? or r.description like ?;",
                new Object[] { searchStr,searchStr },
                recipeRowMapper);
    }

    @Override
    public List<Recipe> findFilteredRecipe(RecipeFilterDto recipeFilterDto) {
        System.out.println();
        String sql = "SELECT DISTINCT(r.id),r.title,r.description,r.image,u.username author \n" +
                "FROM recipes r INNER JOIN users u ON r.author_id = u.id \n" +
                "INNER JOIN ingred_to_rec itc ON itc.rec_id = r.id\n" +
                "INNER JOIN rec_to_categ rtc ON rtc.rec_id = r.id\n" +
                "WHERE (LOWER(r.title) like :query or LOWER(r.description) like :query) \n";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        if (recipeFilterDto.getQuery() != null) {
            parameters.addValue("query", "%" + recipeFilterDto.getQuery() + "%");
        } else {
            parameters.addValue("query", "%%");
        }
        List<Integer> intList = new ArrayList<>();
        if (recipeFilterDto.getCategory() != null) {
            for (String s : recipeFilterDto.getCategory()) intList.add(Integer.valueOf(s));
            sql += "AND rtc.cat_id IN (:categories)\n";
        }
        parameters.addValue("categories", intList);
        intList.clear();
        if (recipeFilterDto.getIngredients() != null) {
            for (String s : recipeFilterDto.getIngredients()) intList.add(Integer.valueOf(s));
            sql += "AND itc.ingr_id IN (:ingredients)";

        }
        parameters.addValue("ingredients", intList);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());

        return template.query(sql,
                parameters,
                recipeRowMapper);

    }

    @Override
    public void approve(Long id) {
        jdbcTemplate.update(
                "UPDATE recipes SET approved = ? WHERE id = ?",
                true,
                id
        );
    }
}
