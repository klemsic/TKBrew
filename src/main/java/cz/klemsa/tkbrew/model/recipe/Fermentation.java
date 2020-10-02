package cz.klemsa.tkbrew.model.recipe;

import org.springframework.data.annotation.PersistenceConstructor;

public class Fermentation {
    private String a;

    @PersistenceConstructor
    public Fermentation() {
        this.a = "";
    }

    public Fermentation(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }
}
