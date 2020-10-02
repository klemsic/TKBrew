package cz.klemsa.tkbrew.controller;

import cz.klemsa.tkbrew.model.ingredient.Water;
import cz.klemsa.tkbrew.model.recipe.Recipe;
import cz.klemsa.tkbrew.model.recipe.WaterRow;
import cz.klemsa.tkbrew.model.recipe.WaterTable;
import cz.klemsa.tkbrew.repository.recipe.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Recipe>> getAll() {
        List<Recipe> response = recipeRepository.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


//    Recipe.RecipeBuilder builder = new Recipe.RecipeBuilder();
//    builder.setName("Plzeňský ležák");
//    builder.setDescription("Ležák Plzeňského typu.");
//
//    List<WaterRow> waterRows = new ArrayList<>();
//    waterRows.add(new WaterRow(new Water("Voda","Měká voda."),1.0));
//    WaterTable waterTable = new WaterTable(waterRows);
//    builder.setWaterTable(waterTable);
//
//    Recipe recipe = new Recipe(builder);
//
//    recipeRepository.save(recipe);
//
//
//    List<Recipe> response = recipeRepository.findAll();
//
//    return new ResponseEntity<>(true,HttpStatus.OK);

}
