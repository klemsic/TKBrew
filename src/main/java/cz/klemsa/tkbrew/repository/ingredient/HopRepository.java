package cz.klemsa.tkbrew.repository;

import cz.klemsa.tkbrew.model.ingredient.Hop;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HopRepository extends MongoRepository<Hop, ObjectId> {
    // public Ingredient findByName(String name);
    // public List<Ingredient> findByDescription(String description);
}
