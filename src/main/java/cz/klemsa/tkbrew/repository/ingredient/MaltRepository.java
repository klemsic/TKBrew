package cz.klemsa.tkbrew.repository.ingredient;

import cz.klemsa.tkbrew.model.Malt;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaltRepository extends MongoRepository<Malt,Integer> {
    // public Ingredient findByName(String name);
    // public List<Ingredient> findByDescription(String description);
}
