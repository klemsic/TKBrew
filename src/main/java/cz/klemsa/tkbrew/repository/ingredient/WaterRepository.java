package cz.klemsa.tkbrew.repository;

import cz.klemsa.tkbrew.model.ingredient.Water;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterRepository extends MongoRepository<Water, ObjectId> {
    // public Ingredient findByName(String name);
    // public List<Ingredient> findByDescription(String description);
}
