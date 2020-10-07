package cz.klemsa.tkbrew.controller;

import cz.klemsa.tkbrew.model.ingredient.*;
import cz.klemsa.tkbrew.repository.ingredient.*;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Ingredient controller for CRUD operations.
 * @author tomasklemsa
 */
@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private static final String ID_PATH_VARIABLE = "{id:[0-9a-fA-F]{24}}"; // hex value

    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private Logger log;

    // --------------------------------------------------
    // - GET Methods
    // --------------------------------------------------

    /**
     * Gets ingredient by specific id.
     * @param id in hexadecimal form like "5f7ac903e3ba595a5580e764"
     * @return ingredient
     */
    @GetMapping("/" + ID_PATH_VARIABLE)
    public ResponseEntity<Ingredient> getIngredient(@PathVariable("id") String id) {
        if (ObjectId.isValid(id)) {
            Optional<Ingredient>  ingredient = ingredientRepository.findById(new ObjectId(id));

            if (ingredient.isEmpty()) {
                log.info("Ingredient with id=" + id + " is not found.");
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            } else {
                log.info("Getting ingredient with id=" + id);
                return new ResponseEntity<>(ingredient.get(), HttpStatus.OK);
            }
        } else {
            log.info("Ingredient id=" + id + " is not valid.");
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    /**
     *
     * @return all ingredients
     */
    @GetMapping
    public ResponseEntity<List<Ingredient>> getAll() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        log.info("Getting all ingredients.");
        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }

    // --------------------------------------------------
    // - POST Methods
    // --------------------------------------------------

    /**
     *
     * @param hop
     * @return
     */
    @PostMapping(value = "/hop")
    public ResponseEntity<String> createHop(@RequestBody Hop hop) {
        return insertIngredient(hop);
    }

    /**
     *
     * @param malt
     * @return
     */
    @PostMapping(value = "/malt")
    public ResponseEntity<String> createMalt(@RequestBody Malt malt) {
        return insertIngredient(malt);
    }

    /**
     *
     * @param water
     * @return
     */
    @PostMapping(value = "/water")
    public ResponseEntity<String> createWater(@RequestBody Water water) {
        return insertIngredient(water);
    }

    /**
     *
     * @param yeast
     * @return
     */
    @PostMapping(value = "/yeast")
    public ResponseEntity<String> createYeast(@RequestBody Yeast yeast) {
        return insertIngredient(yeast);
    }

    /**
     *
     * @param ingredient
     * @return
     */
    private ResponseEntity<String> insertIngredient(Ingredient ingredient) {
        ObjectId id = new ObjectId(ingredient.getId());

        // If ingredient with this id is already exists in database.
        if (ingredientRepository.findById(id).isPresent()) {
            log.warn("Ingredient with id=" + id + " already exists.");
            return new ResponseEntity<>(id.toHexString(), HttpStatus.CONFLICT);
        } else { // Else insert ingredient into database
            ingredientRepository.insert(ingredient);
            log.info("New ingredient is created with id=" + id);
            return new ResponseEntity<>(id.toHexString(), HttpStatus.CREATED);
        }
    }

    // --------------------------------------------------
    // - PUT Methods
    // --------------------------------------------------

    /**
     *
     * @param id in hexadecimal form like "5f7ac903e3ba595a5580e764"
     * @param hop
     * @return
     */
    @PutMapping("/hop/" + ID_PATH_VARIABLE)
    public ResponseEntity<Void> updateHop(@PathVariable("id") String id, @RequestBody Hop hop) {
        Hop copy = new Hop(new ObjectId(id), hop); // Create new ingredient with specific id.
        return updateIngredient(copy);
    }

    /**
     *
     * @param id in hexadecimal form like "5f7ac903e3ba595a5580e764"
     * @param malt
     * @return
     */
    @PutMapping("/malt/" + ID_PATH_VARIABLE)
    public ResponseEntity<Void> updateMalt(@PathVariable("id") String id, @RequestBody Malt malt) {
        Malt copy = new Malt(new ObjectId(id), malt); // Create new ingredient with specific id.
        return updateIngredient(copy);
    }

    /**
     *
     * @param id in hexadecimal form like "5f7ac903e3ba595a5580e764"
     * @param water
     * @return
     */
    @PutMapping("/water/" + ID_PATH_VARIABLE)
    public ResponseEntity<Void> updateWater(@PathVariable("id") String id, @RequestBody Water water) {
        Water copy = new Water(new ObjectId(id), water); // Create new ingredient with specific id.
        return updateIngredient(copy);
    }

    /**
     *
     * @param id in hexadecimal form like "5f7ac903e3ba595a5580e764"
     * @param yeast
     * @return
     */
    @PutMapping("/yeast/" + ID_PATH_VARIABLE)
    public ResponseEntity<Void> updateYeast(@PathVariable("id") String id, @RequestBody Yeast yeast) {
        Yeast copy = new Yeast(new ObjectId(id), yeast); // Create new ingredient with specific id.
        return updateIngredient(copy);
    }

    /**
     * @Path
     * @param ingredient
     * @return
     */
    private ResponseEntity<Void> updateIngredient(Ingredient ingredient) {
        ObjectId id = new ObjectId(ingredient.getId());

        // If ingredient with this id is not exists in database.
        if (ingredientRepository.findById(id).isEmpty()) {
            log.warn("Ingredient with id=" + id + " doesn't exist.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else { // Else update ingredient in database
            ingredientRepository.save(ingredient);
            log.info("New ingredient is created with id=" + id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    // --------------------------------------------------
    // - DELETE Methods
    // --------------------------------------------------

    /**
     *
     * @param id in hexadecimal form like "5f7ac903e3ba595a5580e764"
     * @return
     */
    @DeleteMapping("/" + ID_PATH_VARIABLE)
    public ResponseEntity<Void> deleteIngredient(@PathVariable("id") String id) {
        ObjectId objectId = new ObjectId(id);

        if (ingredientRepository.findById(objectId).isPresent()) {
            ingredientRepository.deleteById(objectId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
