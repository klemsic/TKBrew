package cz.klemsa.tkbrew.controller;

import cz.klemsa.tkbrew.model.ingredient.Ingredient;
import cz.klemsa.tkbrew.repository.ingredient.IngredientRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {
    @Autowired
    private Logger log;
    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping
    public List<Ingredient> getAll(@RequestParam(value = "id", required = false) String id) {
//        Malt malt = new Malt("Plzeňský", "Světlý slad pro až  100% sypání.",3.0,0.95);
//        Malt malt1 = new Malt("Bavorský", "Bavorský slad.",25.0,0.85);
//
//        ingredientRepository.save(malt);
//        ingredientRepository.save(malt1);
//        ingredientRepository.save(new Hop("Premiant","Chmel pro dvojí použití.",8.1,4.6));
//        ingredientRepository.save(new Water("Plzeňská voda", "Voda ze studny."));

        // maltRepository.save(malt);

        // Mash mash = new Mash(MashType.DOUBLE_DECOCTION,List.of(new IngredientRow(malt,0.9),new IngredientRow(malt1,0.1)));



        log.info("Getting all ingredients.");
        List<Ingredient> i = ingredientRepository.findAll();
        return i;
    }

}
