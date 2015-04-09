package model.area;

import java.util.List;

import utilities.AreaAngle;
import utilities.LocationConversion;

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

    protected Location createComparisonLocation(Location location) {
        Location centerLoc = centerLocation(location);

        Location testLocation = new Location((centerLoc.getX() - super.getStartLocation().getX()),
                ((-1 * centerLoc.getY()) + super.getStartLocation().getY()));
        
        return testLocation;
    }
    
    protected Location centerLocation(Location location) {
        return LocationConversion.convertLocationToCenterOfHexagon(location);
    }

    /**
     * Uncomment when structure map comes in.
     * 
     * @Override public abstract StructuredMap save();
     * @Override public abstract Area load(StructuredMap map);
     */
}
