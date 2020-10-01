package cz.klemsa.tkbrew.repository.ingredient;

import cz.klemsa.tkbrew.model.ingredient.Malt;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaltRepository extends MongoRepository<Malt, ObjectId> {
    // public Ingredient findByName(String name);
    // public List<Ingredient> findByDescription(String description);
}
