package model.area;

import java.util.ArrayList;
import java.util.List;

import utilities.AreaAngle;
import utilities.LocationConversion;
import utilities.structuredmap.SavableLoadable;
import utilities.structuredmap.StructuredMap;

public abstract class Area implements SavableLoadable {
    private int range;
    private Location startLocation;

    public Area(int radius, Location startLocation) {
        this.range = radius;
        this.startLocation = startLocation;
    }

    public Area() {
        this.range = 1;
        this.startLocation = new Location();
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public int getRadius() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public abstract boolean isInRange(Location location);

    protected boolean isWithinRadius(Location loc) {
        double radiusMultiplier = LocationConversion.getRadius();

        return Math.pow(getStartLocation().getX() - loc.getX(), 2)
                + Math.pow(getStartLocation().getY() - loc.getY(), 2) <= Math.pow(
                ((getRadius() - 1) * radiusMultiplier), 2);
    }

    /**
     * Super ugly. Leaving as is until we figure out Hexagon math for sure. Not
     * fun shit. Algorthim basically checks all directions and checks if its
     * already been added or if it's in the range and then adds itself;
     * 
     * @param location
     * @param returnList
     * @return
     */
    protected List<Location> checkSurrounding(Location location, List<Location> returnList) {
        List<Location> testLocations = new ArrayList<>();
        double height = LocationConversion.getHeight();
        
        for(AreaAngle angle : AreaAngle.values()) {
            double xOffset = Math.round(height * Math.cos(Math.toRadians(angle.getAngle() + 30)));
            double yOffset = Math.round(height * Math.sin(Math.toRadians(angle.getAngle() + 30)));
            Location testLocation = new Location(location.getX() + xOffset, location.getY() - yOffset);

            if(canAdd(testLocation, returnList)) {
                returnList.add(testLocation);
            }
        }
        return testLocations;

    }

    private boolean canAdd(Location location, List<Location> locations) {
        return !locations.contains(location) && isInRange(location);
    }

    public abstract List<Location> getCoveredLocations();
    public abstract StructuredMap getStructuredMap();
    public abstract void load(StructuredMap map);
}
