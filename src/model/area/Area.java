package model.area;

import java.util.List;

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

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public abstract boolean isInRange(Location location);

    public abstract List<Location> getCoveredLocations();
    /**
     * Uncomment when we get structured map public abstract StructuredMap
     * save(); public abstract Area load(StructuredMap map);
     */
}
