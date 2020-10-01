package cz.klemsa.tkbrew.model.recipe;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recipe")
public class Recipe {

    @Id
    private ObjectId  objectId;

    private String Name;

    private String Description;

    

    private WaterTable waterTable;

    private Mash mash;

    private Boil boil;

    private Fermentation fermentation;
}
