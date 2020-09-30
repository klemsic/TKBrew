package cz.klemsa.tkbrew.repository.ingredient;

import cz.klemsa.tkbrew.model.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends MongoRepository<Ingredient,Integer> {
    // public Ingredient findByName(String name);
    // public List<Ingredient> findByDescription(String description);
}
