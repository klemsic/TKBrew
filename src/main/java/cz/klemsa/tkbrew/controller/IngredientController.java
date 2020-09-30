package cz.klemsa.tkbrew.controller;

import cz.klemsa.tkbrew.model.Hop;
import cz.klemsa.tkbrew.model.Ingredient;
import cz.klemsa.tkbrew.model.Malt;
import cz.klemsa.tkbrew.repository.ingredient.HopRepository;
import cz.klemsa.tkbrew.repository.ingredient.IngredientRepository;
import cz.klemsa.tkbrew.repository.ingredient.MaltRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    private HopRepository hopRepository;

    @Autowired
    private MaltRepository maltRepository;

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientController(IngredientRepository userRepository) {
        this.ingredientRepository = userRepository;
    }

    @GetMapping("/all")
    public List<Ingredient> getAllIngredients() {
        hopRepository.save(new Hop(1,"Premiant","Chmel pro dvojí použití.",8.1));
        maltRepository.save(new Malt(2,"Plzeňský", "Světlí slad pro až  100% sypání.",3.0));
        LOG.info("Getting all ingredients.");
        return ingredientRepository.findAll();
    }

}
