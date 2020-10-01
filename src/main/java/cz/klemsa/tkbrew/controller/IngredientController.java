package cz.klemsa.tkbrew.controller;

import cz.klemsa.tkbrew.model.ingredient.*;
import cz.klemsa.tkbrew.model.recipe.IngredientRow;
import cz.klemsa.tkbrew.model.recipe.Mash;
import cz.klemsa.tkbrew.model.recipe.MashType;
import cz.klemsa.tkbrew.repository.ingredient.HopRepository;
import cz.klemsa.tkbrew.repository.ingredient.IngredientRepository;
import cz.klemsa.tkbrew.repository.ingredient.MaltRepository;
import cz.klemsa.tkbrew.repository.ingredient.WaterRepository;
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

    @Autowired
    private WaterRepository waterRepository;

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientController(IngredientRepository userRepository) {
        this.ingredientRepository = userRepository;
    }

    @GetMapping("/all")
    public List<Ingredient> getAllIngredients() {
        Malt malt = new Malt("Plzeňský", "Světlý slad pro až  100% sypání.",3.0,0.95);
        Malt malt1 = new Malt("Bavorský", "Bavorský slad.",25.0,0.85);

        maltRepository.save(malt);
        maltRepository.save(malt1);
        //hopRepository.save(new Hop("Premiant","Chmel pro dvojí použití.",8.1,4.6, HopPurpose.BITTERNESS));
        // waterRepository.save(new Water("Plzeňská voda", "Voda ze studny."));

       // maltRepository.save(malt);

       // Mash mash = new Mash(MashType.DOUBLE_DECOCTION,List.of(new IngredientRow(malt,0.9),new IngredientRow(malt1,0.1)));


        LOG.info("Getting all ingredients.");
        List<Ingredient>i =  ingredientRepository.findAll();
        return i;
    }

}
