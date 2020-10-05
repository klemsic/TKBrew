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
    private final ObjectId id;

    private final String name;
    private final String description;

    /**
     * No-arg constructor that's create ingredient with default fields.
     */
    public Ingredient() {
        this(DEFAULT_NAME, DEFAULT_DESCRIPTION);
    }

    /**
     *
     * @param name of ingredient if null it will be set to an empty string
     * @param description of ingredient if null it will be set to an empty string
     */
    public Ingredient(String name, String description) {
        this(new ObjectId(), name, description);
    }

    /**
     *
     * @param id if null it will be set to an new ObjectId.
     * @param name of ingredient if null it will be set to an empty string
     * @param description of ingredient if null it will be set to an empty string
     */
    public Ingredient(ObjectId id, String name, String description) {
        this.id = id == null ? new ObjectId() : id;
        this.name = name == null ? DEFAULT_NAME : name;
        this.description = description == null ? DEFAULT_DESCRIPTION : description;
    }

    public String getId() {
        return id.toHexString();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
