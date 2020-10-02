package cz.klemsa.tkbrew.model.recipe;

import org.springframework.data.annotation.PersistenceConstructor;

public class Boil {
    private String a;

    @PersistenceConstructor
    public Boil(String a) {
        this.a = a;
    }

    public Boil() {
        this.a = "";
    }

    public String getA() {
        return a;
    }
}
