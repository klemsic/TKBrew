package cz.klemsa.tkbrew.model.recipe;

import cz.klemsa.tkbrew.model.ingredient.Ingredient;

public class IngredientRow {

    Ingredient ingredient;

    double percent;

    public IngredientRow(Ingredient ingredient, double percent) {
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
