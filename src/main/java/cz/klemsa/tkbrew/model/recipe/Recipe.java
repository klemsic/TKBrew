package cz.klemsa.tkbrew.model.recipe;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class that's represents recipe.
 */
@Document(collection = "recipe")
public final class Recipe {
    private static final String DEFAULT_NAME = "";
    private static final String DEFAULT_DESCRIPTION = "";
    private static final WaterTable DEFAULT_WATER_TABLE = new WaterTable();
    private static final Mash DEFAULT_MASH = new Mash();
    private static final Boil DEFAULT_BOIL = new Boil();
    private static final Fermentation DEFAULT_FERMENTATION = new Fermentation();

    @Id
    private final ObjectId  objectId;

    private final String name;
    private final String description;
    private final WaterTable waterTable;
    private final Mash mash;
    private final Boil boil;
    private final Fermentation fermentation;

    /**
     * Recipe builder.
     */
    public static class RecipeBuilder {
        private ObjectId  objectId;

        private String name;
        private String description;
        private WaterTable waterTable;
        private Mash mash;
        private Boil boil;
        private Fermentation fermentation;

        public void setObjectId(ObjectId objectId) {
            this.objectId = objectId;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setWaterTable(WaterTable waterTable) {
            this.waterTable = waterTable;
        }

        public void setMash(Mash mash) {
            this.mash = mash;
        }

        public void setBoil(Boil boil) {
            this.boil = boil;
        }

        public void setFermentation(Fermentation fermentation) {
            this.fermentation = fermentation;
        }

        public Recipe build() {
            return new Recipe(this);
        }
    }

    /**
     *
     * @param recipeBuilder witch used to build recipe.
     */
    public Recipe(RecipeBuilder recipeBuilder) {
        this(recipeBuilder.objectId,
                recipeBuilder.name,
                recipeBuilder.description,
                recipeBuilder.waterTable,
                recipeBuilder.mash,
                recipeBuilder.boil,
                recipeBuilder.fermentation);
    }

    /**
     * No-arg constructor that's create recipe with default fields.
     */
    public Recipe() {
        this(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_WATER_TABLE, DEFAULT_MASH, DEFAULT_BOIL, DEFAULT_FERMENTATION);
    }

    /**
     *
     * @param name of recipe
     * @param description of recipe
     * @param waterTable used in recipe
     * @param mash used in recipe
     * @param boil used in recipe
     * @param fermentation used in recipe
     */
    public Recipe(String name, String description, WaterTable waterTable, Mash mash, Boil boil, Fermentation fermentation) {
        this(new ObjectId(), name, description, waterTable, mash, boil, fermentation);
    }


    /**
     *
     * @param objectId used to persist
     * @param name of recipe
     * @param description of recipe
     * @param waterTable used in recipe
     * @param mash used in recipe
     * @param boil used in recipe
     * @param fermentation used in recipe
     */
    @PersistenceConstructor
    public Recipe(ObjectId objectId, String name, String description, WaterTable waterTable, Mash mash, Boil boil, Fermentation fermentation) {
        this.objectId = objectId == null ? new ObjectId() : objectId;
        this.name = name == null ? DEFAULT_NAME : name;
        this.description = description == null ? DEFAULT_DESCRIPTION : null;
        this.waterTable = waterTable == null ? DEFAULT_WATER_TABLE : null;
        this.mash = mash == null ? DEFAULT_MASH : mash;
        this.boil = boil == null ? DEFAULT_BOIL : boil;
        this.fermentation = fermentation == null ? DEFAULT_FERMENTATION : fermentation;
    }

    public String getObjectId() {
        return objectId.toHexString();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public WaterTable getWaterTable() {
        return waterTable;
    }

    public Mash getMash() {
        return mash;
    }

    public Boil getBoil() {
        return boil;
    }

    public Fermentation getFermentation() {
        return fermentation;
    }
}
