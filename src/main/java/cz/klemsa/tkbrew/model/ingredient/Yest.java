package cz.klemsa.tkbrew.model.ingredient;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class that's represents yeast.
 * @author tomasklemsa
 */
@Document(collection = "ingredient")
public class Yest extends Ingredient {
    private static final double DEFAULT_ATTENUATION = 0.75;
    private static final YeastType DEFAULT_YEAST_TYPE = YeastType.UNKNOWN;

    private final double attenuation;
    private final YeastType yeastType;

    /**
     * No-arg constructor that's create object with default fields.
     */
    public Yest() {
        super();
        this.attenuation = DEFAULT_ATTENUATION;
        this.yeastType = DEFAULT_YEAST_TYPE;
    }

    /**
     *
     * @param name of ingredient
     * @param description of ingredient
     * @param attenuation of yeast, 75% of attenuation = 0.75
     * @param yeastType of yeast
     */
    public Yest(String name, String description, double attenuation, YeastType yeastType) {
        super(name, description);
        this.attenuation = attenuation;
        this.yeastType = yeastType == null ? DEFAULT_YEAST_TYPE : yeastType;
    }

    /**
     *
     * @param objectId used to persist
     * @param name of ingredient
     * @param description of ingredient
     * @param attenuation of yeast, 75% of attenuation = 0.75
     * @param yeastType of yeast
     */
    @PersistenceConstructor
    public Yest(ObjectId objectId, String name, String description, double attenuation, YeastType yeastType) {
        super(objectId, name, description);
        this.attenuation = attenuation;
        this.yeastType = yeastType == null ? DEFAULT_YEAST_TYPE : yeastType;
    }

    public double getAttenuation() {
        return attenuation;
    }

    public YeastType getYeastType() {
        return yeastType;
    }
}
