package cz.klemsa.tkbrew.model.recipe;

import java.util.ArrayList;
import java.util.List;

public class WaterTable {
    private static final List<WaterRow> DEFAULT_WATER_ROWS = new ArrayList<>(0);

    private final List<WaterRow> waterRows;

    public WaterTable() {
        this(DEFAULT_WATER_ROWS);
    }

    public WaterTable(List<WaterRow> waterRows) {
        this.waterRows = List.copyOf(waterRows);
    }

    public List<WaterRow> getWaterRows() {
        return List.copyOf(waterRows);
    }
}
