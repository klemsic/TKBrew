package cz.klemsa.tkbrew.model.ingredient;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ingredient")
public class Water extends Ingredient {

    /**
     * No-arg constructor that's create object with default fields.
     */
    public Water() {
        super();
    }

    /**
     *
     * @param name of ingredient
     * @param description of ingredient
     */
    public Water(String name, String description) {
        super(name, description);
    }

    /**
     *
     * @param objectId used to persist
     * @param name of ingredient
     * @param description of ingredient
     */
    public Water(String objectId, String name, String description) {
        super(new ObjectId(objectId), name, description);
    }
}
