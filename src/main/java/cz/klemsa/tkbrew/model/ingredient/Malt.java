package cz.klemsa.tkbrew.model.ingredient;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class that's represents malt.
 * @author tomasklemsa
 */
@Document(collection = "ingredient")
public final class Malt extends Ingredient {
    private static final double DEFAULT_COLOR = 0.0;
    private static final double DEFAULT_YIELD = 0.75;

    private final double color; // Color in EBC units.
    private final double yield;

    /**
     * No-arg constructor that's create malt with default fields.
     */
    public Malt() {
        this(null, null, DEFAULT_COLOR, DEFAULT_YIELD);
    }

    /**
     *
     * @param name of ingredient
     * @param description of ingredient
     * @param color of malt in EBC units
     * @param yield of malt, 75% yield = 0.75
     */
    public Malt(String name, String description, Double color, Double yield) {
        this(new ObjectId(), name, description, color, yield);
    }

    /**
     * Copy constructor witch create malt with new id.
     * @param id of new malt, or null and it will be created automatically
     * @param malt from which we want to make a copy
     */
    public Malt(ObjectId id, Malt malt) {
        this(id, malt.getName(), malt.getDescription(), malt.color, malt.yield);
    }

    /**
     *
     * @param id used to persist
     * @param name of ingredient
     * @param description of ingredient
     * @param color of malt in EBC units
     * @param yield of malt, 75% yield = 0.75
     */
    @PersistenceConstructor
    public Malt(ObjectId id, String name, String description, Double color, Double yield) {
        super(id, name, description);
        this.color = color == null ? DEFAULT_COLOR : color;
        this.yield = yield == null ? DEFAULT_YIELD : yield;
    }

    public double getColor() {
        return color;
    }

    public double getYield() {
        return yield;
    }
}
