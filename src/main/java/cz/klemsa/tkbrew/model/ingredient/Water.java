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
        this((String) null, (String) null);
    }

    /**
     * Copy constructor witch create water with new id.
     * @param id of new water, or null and it will be created automatically
     * @param water from which we want to make a copy
     */
    public Water(ObjectId id, Water water) {
        this(id, water.getName(), water.getDescription());
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
     * @param id used to persist
     * @param name of ingredient
     * @param description of ingredient
     */
    @PersistenceConstructor
    public Water(ObjectId id, String name, String description) {
        super(id, name, description);
    }
}
