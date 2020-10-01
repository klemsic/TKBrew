package cz.klemsa.tkbrew.model;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@TypeAlias("Malt")
@Document(collection = "ingredient")
public class Malt extends Ingredient {

    private double color;

    public Malt(int id, String name, String description, double color) {
        super(id, name, description);
        this.color = color;
    }

    public double getColor() {
        return color;
    }

}
