package cz.klemsa.tkbrew.model.recipe;

import org.springframework.data.annotation.PersistenceConstructor;

import java.util.ArrayList;
import java.util.List;

public class Mash {
    private static final double DEFAULT_GRAVITY = 10.0;
    private static final MashType DEFAULT_MASH_TYPE = MashType.DOUBLE_DECOCTION;
    private static final List<MashRow> DEFAULT_MASH_ROWS = new ArrayList<>(0);

    private final double gravity; // °P
    private final MashType mashType;
    private final List<MashRow> mashRows;

    public Mash() {
        this(DEFAULT_GRAVITY, DEFAULT_MASH_TYPE, DEFAULT_MASH_ROWS);
    }

    @PersistenceConstructor
    public Mash(double gravity, MashType mashType, List<MashRow> mashRows) {
        this.gravity = gravity;
        this.mashType = mashType;
        this.mashRows = List.copyOf(mashRows);
    }

    public double getGravity() {
        return gravity;
    }

    public MashType getMashType() {
        return mashType;
    }

    public List<MashRow> getMashRows() {
        return List.copyOf(mashRows);
    }
}
