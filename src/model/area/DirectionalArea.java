package model.area;

import java.util.List;

import utilities.AreaAngle;

public abstract class DirectionalArea extends Area {

    private AreaAngle direction;

    public DirectionalArea(int radius, Location startLocation, AreaAngle angle) {
        super(radius, startLocation);
        this.direction = angle;
    }

    public DirectionalArea() {
        super();
        this.direction = AreaAngle.UP;
    }

    public AreaAngle getDirection() {
        return direction;
    }

    public void setDirection(AreaAngle direction) {
        this.direction = direction;
    }

    @Override
    public abstract boolean isInRange(Location location);

    @Override
    public abstract List<Location> getCoveredLocations();
    
    protected boolean isWithinRadius(Location loc) {
        return Math.pow(super.getStartLocation().getX() - loc.getX(), 2)
                + Math.pow(super.getStartLocation().getY() - loc.getY(), 2) < Math.pow(super.getRadius(), 2);
    }

    /**
     * Uncomment when structure map comes in.
     * 
     * @Override public abstract StructuredMap save();
     * @Override public abstract Area load(StructuredMap map);
     */
}
