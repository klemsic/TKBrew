package cz.klemsa.tkbrew.repository.ingredient;

import cz.klemsa.tkbrew.model.Hop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HopRepository extends MongoRepository<Hop,Integer> {
    // public Ingredient findByName(String name);
    // public List<Ingredient> findByDescription(String description);
}
