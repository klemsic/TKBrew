package cz.klemsa.tkbrew.model.recipe;

import cz.klemsa.tkbrew.model.ingredient.Ingredient;

public class WaterRow {

    private final Ingredient ingredient;
    private final double percent;

    public WaterRow(Ingredient ingredient, double percent) {
        this.ingredient = ingredient;
        this.percent = percent;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public double getPercent() {
        return percent;
    }
}
