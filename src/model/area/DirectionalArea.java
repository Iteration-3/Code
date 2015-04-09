package model.area;

import java.util.List;

import utilities.Angle;

public abstract class DirectionalArea extends Area {

    private Angle direction;

    public DirectionalArea(int radius, Location startLocation, Angle angle) {
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
    public abstract boolean isInRange(Location location);

    @Override
    public abstract List<Location> getCoveredLocations();

    /**
     * Uncomment when structure map comes in.
     * 
     * @Override public abstract StructuredMap save();
     * @Override public abstract Area load(StructuredMap map);
     */
}
