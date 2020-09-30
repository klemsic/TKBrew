package cz.klemsa.tkbrew.model;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@TypeAlias("Ingredient")
@Document(collection = "ingredient")
public class Hop extends Ingredient {

    public Hop(int id, String name, String description, double alpha) {
        super(id, name, description);
        this.alpha = alpha;
    }

    private double alpha;

    public double getAlpha() {
        return alpha;
    }

}
