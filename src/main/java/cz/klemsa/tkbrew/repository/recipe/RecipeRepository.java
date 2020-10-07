package cz.klemsa.tkbrew.repository.recipe;

import cz.klemsa.tkbrew.model.recipe.Recipe;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, ObjectId> {
    // public Ingredient findByName(String name);
    // public List<Ingredient> findByDescription(String description);
}
