package model.area;

import java.util.List;

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
                + Math.pow(getStartLocation().getY() - loc.getY(), 2) <= Math.pow(getRadius() * radiusMultiplier/2.0, 2);
    }

    public abstract List<Location> getCoveredLocations();
    public abstract StructuredMap getStructuredMap();
    public abstract void load(StructuredMap map);
}
