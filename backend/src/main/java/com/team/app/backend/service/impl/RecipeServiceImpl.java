package com.team.app.backend.service.impl;

import com.team.app.backend.dto.RecipeCreateDto;
import com.team.app.backend.dto.RecipeFilterDto;
import com.team.app.backend.persistance.dao.*;
import com.team.app.backend.persistance.model.Image;
import com.team.app.backend.persistance.model.Recipe;
import com.team.app.backend.persistance.model.RecipeCategory;
import com.team.app.backend.persistance.model.RecipeWithContent;
import com.team.app.backend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeDao recipeDao;

    @Autowired
    private IngredientsDao ingredientsDao;

    @Autowired
    private RecipeStepDao recipeStepDao;

    @Autowired
    private RecipeCategoryDao recipeCategoryDao;

    @Override
    public void deleteRecipe(Long id) {
        recipeDao.delete(id);
    }

    @Override
    public void addRecipe(RecipeCreateDto recipeCreateDto,long user_id) throws IOException {
        Recipe recipe = new Recipe();
        recipe.setTitle(recipeCreateDto.getTitle());
        recipe.setDescription(recipeCreateDto.getDescription());
        recipe.setImageUrl(recipeCreateDto.getImageUrl());
        recipe.setImageFile(compressBytes(recipeCreateDto.getFile().getBytes()));
        long rec_id = recipeDao.add(recipe, user_id);
        //System.out.println("Original Image Byte Size - " + file.getBytes().length);
        ingredientsDao.addRecipeIngred(rec_id, recipeCreateDto.getIngredients());
        recipeStepDao.addRecipeSteps(rec_id, recipeCreateDto.getSteps());
        recipeCategoryDao.addRecipeCateg(rec_id, recipeCreateDto.getCategories());
    }

    @Override
    public void approveRecipe(Long id){
        recipeDao.approve(id);
    }

    @Override
    public void likeRecipe(Long rec_id, Long user_id, boolean is_liked){
        recipeDao.likeRecipe(rec_id, user_id, is_liked);
    }

    @Override
    public RecipeWithContent getRecipeById(Long id) {
        return new RecipeWithContent(recipeDao.get(id),ingredientsDao.getRecipes(id),recipeStepDao.getRecipes(id));
    }

    @Override
    public List<Recipe> getRecipesByCategory(String category) {
        return recipeDao.getRecipesByCategory(category);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeDao.getAll();
    }

    @Override
    public List<Recipe> getNotApprovedRecipes() {
        return recipeDao.getNotApproved();
    }

    @Override
    public List<Recipe> searchByString(String searchStr) {
        return recipeDao.getRecipesBySearchStr(searchStr);
    }

    @Override
    public List<Recipe> findFilteredRecipe(RecipeFilterDto recipeFilterDto) {
        return recipeDao.findFilteredRecipe(recipeFilterDto);
    }


    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }
    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }

}
