package model.area;

import java.util.ArrayList;
import java.util.List;

import utilities.Angle;
import utilities.structuredmap.StructuredMap;

public abstract class DirectionalArea extends Area {

    private Angle direction;

    public DirectionalArea(int radius, TileCoordinate startLocation, Angle angle) {
        super(radius, startLocation);
        this.direction = angle;
    }

    public DirectionalArea() {
        super();
        this.direction = Angle.UP;
    }

    public Angle getDirection() {
        return direction;
    }

    public void setDirection(Angle direction) {
        this.direction = direction;
    }

    @Override
    public abstract boolean isInRange(TileCoordinate location);

    @Override
    public abstract List<TileCoordinate> getCoveredLocations();

    @Override
    public abstract StructuredMap getStructuredMap();

    @Override
    public abstract void load(StructuredMap map);
}
