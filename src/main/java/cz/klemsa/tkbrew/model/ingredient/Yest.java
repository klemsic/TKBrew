package cz.klemsa.tkbrew.model.ingredient;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class that's represents hop.
 * @author tomasklemsa
 */
@Document(collection = "ingredient")
public class Hop extends Ingredient {
    private static final double DEFAULT_ALPHA = 0.0;
    private static final double DEFAULT_BETA = 0.0;

    private final double alpha;
    private final double beta;

    /**
     * No-arg constructor that's create object with default fields.
     */
    public Hop() {
        super();
        this.alpha = DEFAULT_ALPHA;
        this.beta = DEFAULT_BETA;
    }

    /**
     *
     * @param name of ingredient
     * @param description of ingredient
     * @param alpha acids, 10% of alpha acids = 0.1
     * @param beta acids, 10% of beta acids = 0.1
     */
    public Hop(String name, String description, double alpha, double beta) {
        super(name, description);
        this.alpha = alpha ;
        this.beta = beta;
    }

    /**
     *
     * @param objectId used to persist
     * @param name of ingredient
     * @param description of ingredient
     * @param alpha acids, 10% of alpha acids = 0.1
     * @param beta acids, 10% of beta acids = 0.1
     */
    @PersistenceConstructor
    public Hop(ObjectId objectId, String name, String description, double alpha, double beta) {
        super(objectId, name, description);
        this.alpha = alpha;
        this.beta = beta;
    }

    public double getAlpha() {
        return alpha;
    }

    public double getBeta() {
        return beta;
    }

}
