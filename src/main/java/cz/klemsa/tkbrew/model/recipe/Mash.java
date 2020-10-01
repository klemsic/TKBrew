package cz.klemsa.tkbrew.model.recipe;

import org.bson.types.ObjectId;

import java.util.List;

public class Mash {

    private MashType mashType;

    private List<IngredientRow> ingredientRows;

    public Mash(MashType mashType, List<IngredientRow> ingredientRows) {
        this.mashType = mashType;
        this.ingredientRows = ingredientRows;
    }


    public MashType getMashType() {
        return mashType;
    }

    public List<IngredientRow> getIngredientRows() {
        return ingredientRows;
    }
}
