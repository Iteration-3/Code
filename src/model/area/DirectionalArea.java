package model.area;

import java.util.List;

import utilities.AreaAngle;
import utilities.LocationConversion;
import utilities.structuredmap.SavableLoadable;
import utilities.structuredmap.StructuredMap;

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


    @Override 
    public abstract StructuredMap getStructuredMap();
    @Override 
    public abstract void load(StructuredMap map);
}
