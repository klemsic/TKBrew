package cz.klemsa.tkbrew.model;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@TypeAlias("Water")
@Document(collection = "ingredient")
public class Water extends Ingredient {

    public Water(int id, String name, String description) {
        super(id, name, description);
    }
}
