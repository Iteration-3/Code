package model.area;

import java.util.ArrayList;
import java.util.List;

import utilities.LocationConversion;

public abstract class Area {
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
        double width = LocationConversion.getWidth();

        // Up right
        Location testLocation1 = new Location(location.getX() + width * .75, location.getY() - height / 2.0);
        if (canAdd(testLocation1, returnList)) {
            returnList.add(testLocation1);
        }

        // Up
        Location testLocation2 = new Location(location.getX(), location.getY() - height);
        if (canAdd(testLocation2, returnList)) {
            returnList.add(testLocation2);
        }

        // Up left
        Location testLocation3 = new Location(location.getX() - width * .75, location.getY() - height / 2.0);
        if (canAdd(testLocation3, returnList)) {
            returnList.add(testLocation3);
        }

        // Down right
        Location testLocation4 = new Location(location.getX() + width * .75, location.getY() + height / 2.0);
        if (canAdd(testLocation4, returnList)) {
            returnList.add(testLocation4);
        }

        // Down
        Location testLocation5 = new Location(location.getX(), location.getY() + height);
        if (canAdd(testLocation5, returnList)) {
            returnList.add(testLocation5);
        }

        // Down left
        Location testLocation6 = new Location(location.getX() - width * .75, location.getY() + height / 2.0);
        if (canAdd(testLocation6, returnList)) {
            returnList.add(testLocation6);
        }

        return testLocations;

    }

    private boolean canAdd(Location location, List<Location> locations) {
        return !locations.contains(location) && isInRange(location);
    }

    public abstract List<Location> getCoveredLocations();
    /**
     * Uncomment when we get structured map public abstract StructuredMap
     * save(); public abstract Area load(StructuredMap map);
     */
}
