package cz.klemsa.tkbrew.model.ingredient;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class that's represents water.
 * @author tomasklemsa
 */
@Document(collection = "ingredient")
public final class Water extends Ingredient {

    /**
     * No-arg constructor that's create water with default fields.
     */
    public Water() {
        this(null, null);
    }

    /**
     *
     * @param name of ingredient
     * @param description of ingredient
     */
    public Water(String name, String description) {
        this(new ObjectId(), name, description);
    }

    /**
     *
     * @param objectId used to persist
     * @param name of ingredient
     * @param description of ingredient
     */
    @PersistenceConstructor
    public Water(ObjectId objectId, String name, String description) {
        super(objectId, name, description);
    }
}
