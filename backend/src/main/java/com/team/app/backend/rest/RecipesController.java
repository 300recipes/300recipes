package com.team.app.backend.rest;


import com.team.app.backend.config.security.jwt.JwtUtil;
import com.team.app.backend.dto.RecipeCreateDto;
import com.team.app.backend.dto.RecipeFilterDto;
import com.team.app.backend.dto.UserRegistrationDto;
import com.team.app.backend.persistance.dao.RecipeDao;
import com.team.app.backend.persistance.model.Image;
import com.team.app.backend.persistance.model.Recipe;
import com.team.app.backend.persistance.model.RecipeWithContent;
import com.team.app.backend.persistance.model.Role;
import com.team.app.backend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@RequestMapping(path = "api")
public class RecipesController {

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeDao recipeDao;
    @Autowired
    JwtUtil jwtUtil;

    @GetMapping("/recipes")
    public List<Recipe> findAllRecipes(){ return recipeService.getAllRecipes(); }

    @PostMapping("/recipes/add")
    public ResponseEntity addRecipe(@RequestBody RecipeCreateDto recipeCreateDto){
        System.out.println("add " + recipeCreateDto.getTitle());
//        System.out.println(jwtUtil.getUserId("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI4LGFzZGY1LFJfQURNSU4iLCJpc3MiOiJleGFtcGxlLmlvIiwiaWF0IjoxNjE3MzEwNDM4LCJleHAiOjE2MTgxNzQ0Mzh9.rTbmmxeuv-51Ijfzi0S7SdoqWo0PwoCXtbI73qwhfiNcfWCfuFpDjd63S09kH6" +
//                "vesryj0tCVPzZuUgtKLKUOcw"));
        recipeService.addRecipe(recipeCreateDto,11L);
        return ResponseEntity.ok().body("Recipe was successfully added");
    }

    @GetMapping("/recipes/{category}")
    public List<Recipe> findRecipesByCategory(@PathVariable("category") String category){
        return recipeService.getRecipesByCategory(category);
    }

    @PostMapping("/recipes/filter")
    public List<Recipe> findFilteredRecipe(@RequestBody @Valid RecipeFilterDto recipeFilterDto){
        return recipeService.findFilteredRecipe(recipeFilterDto);
    }


    @GetMapping("/recipes/search/{searchStr}")
    public List<Recipe> findRecipesByString(@PathVariable("searchStr") String searchStr){
        return recipeService.searchByString(searchStr);
    }

    @GetMapping("/recipe/{id}")
    public RecipeWithContent findRecipe(@PathVariable("id") long id){
        return recipeService.getRecipeById(id);
    }

    //@RolesAllowed(Role.ADMIN)
    @PostMapping("/recipe/approve/{id}")
    public void approveRecipe(@PathVariable("id") long id){
        recipeService.approveRecipe(id);
    }

    //@RolesAllowed(Role.ADMIN)
    @GetMapping("/recipes/notapproved")
    public List<Recipe> getNotApproved(){
        return recipeService.getNotApprovedRecipes();
    }



    @PostMapping("/image/upload")
    public ResponseEntity.BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {


        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        System.out.println("name" + file.getName());

        Image img = new Image("name1",
                compressBytes(file.getBytes()));
        System.out.println(img.getName());

        recipeDao.saveImage(img);
        return ResponseEntity.status(HttpStatus.OK);

    }


    @GetMapping( "/image/get/{imageName}")
    public Image getImage(@PathVariable("imageName") String imageName) throws IOException {
        System.out.println(imageName);
        final Image retrievedImage = recipeDao.getImage(imageName);

        Image img = new Image(retrievedImage.getName(),
                decompressBytes(retrievedImage.getPicByte()));
        return img;
    }


    // compress the image bytes before storing it in the database

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
