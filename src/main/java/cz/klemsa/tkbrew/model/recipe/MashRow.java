package cz.klemsa.tkbrew.model.recipe;

import cz.klemsa.tkbrew.model.ingredient.Ingredient;

import java.util.Objects;

public class MashRow {

    private Ingredient ingredient;
    private double percent;

    public MashRow(Ingredient ingredient, double percent) {
        this.ingredient = Objects.requireNonNull(ingredient, "Ingredient can't be null.");
        this.percent = percent;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public double getPercent() {
        return percent;
    }
}
