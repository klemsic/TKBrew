package cz.klemsa.tkbrew.model.ingredient;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ingredient")
public class Malt extends Ingredient {
    private static final double DEFAULT_COLOR = 0.0;
    private static final double DEFAULT_YIELD = 0.75;

    private final double color; // Color in EBC units.
    private final double yield;

    /**
     * No-arg constructor that's create object with default fields.
     */
    public Malt() {
        super();
        this.color = DEFAULT_COLOR;
        this.yield = DEFAULT_YIELD;
    }

    /**
     *
     * @param name of ingredient
     * @param description of ingredient
     * @param color of malt in EBC units
     * @param yield of malt, 75% yield = 0.75
     */
    public Malt(String name, String description, double color, double yield) {
        super(name, description);
        this.color = color;
        this.yield = yield;
    }

    /**
     *
     * @param objectId used to persist
     * @param name of ingredient
     * @param description of ingredient
     * @param color of malt in EBC units
     * @param yield of malt, 75% yield = 0.75
     */
    @PersistenceConstructor
    public Malt(ObjectId objectId, String name, String description, double color, double yield) {
        super(objectId, name, description);
        this.color = color;
        this.yield = yield;
    }

    public double getColor() {
        return color;
    }

    public double getYield() {
        return yield;
    }
}
