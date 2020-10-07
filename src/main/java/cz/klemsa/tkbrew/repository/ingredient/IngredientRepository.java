package cz.klemsa.tkbrew.repository.ingredient;

import cz.klemsa.tkbrew.model.ingredient.Ingredient;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends MongoRepository<Ingredient, ObjectId> {
    // public Ingredient findByName(String name);
    // public List<Ingredient> findByDescription(String description);
}
