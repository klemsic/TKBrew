package cz.klemsa.tkbrew.model.ingredient;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class that's represents yeast.
 * @author tomasklemsa
 */
@Document(collection = "ingredient")
public final class Yeast extends Ingredient {
    private static final double DEFAULT_ATTENUATION = 0.75;
    private static final YeastType DEFAULT_YEAST_TYPE = YeastType.UNKNOWN;

    private final double attenuation;
    private final YeastType yeastType;

    /**
     * No-arg constructor that's create yeast with default fields.
     */
    public Yeast() {
        this(null, null, DEFAULT_ATTENUATION, DEFAULT_YEAST_TYPE);
    }

    /**
     *
     * @param name of ingredient
     * @param description of ingredient
     * @param attenuation of yeast, 75% of attenuation = 0.75
     * @param yeastType of yeast
     */
    public Yeast(String name, String description, double attenuation, YeastType yeastType) {
        this(new ObjectId(), name, description, attenuation, yeastType);
    }

    /**
     * Copy constructor witch create yeast with new id.
     * @param id of new yeast, or null and it will be created automatically
     * @param yeast from which we want to make a copy
     */
    public Yeast(ObjectId id, Yeast yeast) {
        this(id, yeast.getName(), yeast.getDescription(), yeast.attenuation, yeast.yeastType);
    }

    /**
     *
     * @param id used to persist
     * @param name of ingredient
     * @param description of ingredient
     * @param attenuation of yeast, 75% of attenuation = 0.75
     * @param yeastType of yeast
     */
    @PersistenceConstructor
    public Yeast(ObjectId id, String name, String description, Double attenuation, YeastType yeastType) {
        super(id, name, description);
        this.attenuation = attenuation == null ? DEFAULT_ATTENUATION : attenuation;
        this.yeastType = yeastType == null ? DEFAULT_YEAST_TYPE : yeastType;
    }

    public double getAttenuation() {
        return attenuation;
    }

    public YeastType getYeastType() {
        return yeastType;
    }
}
