package cz.klemsa.tkbrew.model.ingredient;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Abstract class for ingredients.
 * @author tomasklemsa
 */
public abstract class Ingredient {
    private static final String DEFAULT_NAME = "";
    private static final String DEFAULT_DESCRIPTION = "";

    @Id
    private final ObjectId objectId;

    private final String name;
    private final String description;

    /**
     * No-arg constructor that's create object with default fields.
     */
    public Ingredient() {
        this.objectId = new ObjectId();
        this.name = DEFAULT_NAME;
        this.description = DEFAULT_DESCRIPTION;
    }

    /**
     *
     * @param name of ingredient if null it will be set to an empty string
     * @param description of ingredient if null it will be set to an empty string
     */
    public Ingredient(String name, String description) {
        this.objectId = new ObjectId();
        this.name = name == null ? DEFAULT_NAME : name;
        this.description = description == null ? DEFAULT_DESCRIPTION : description;
    }

    /**
     *
     * @param objectId if null it will be set to an new ObjectId.
     * @param name of ingredient if null it will be set to an empty string
     * @param description of ingredient if null it will be set to an empty string
     */
    public Ingredient(ObjectId objectId, String name, String description) {
        this.objectId = objectId == null ? new ObjectId() : objectId;
        this.name = name == null ? DEFAULT_NAME : name;
        this.description = description == null ? DEFAULT_DESCRIPTION : description;
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
