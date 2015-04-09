package model.area;

import java.util.List;

import utilities.LocationConversion;

public class RadialArea extends Area {

    public RadialArea() {
        super();
    }

    public RadialArea(int radius, Location startLocation) {
        super(radius, startLocation);
    }

    @Override
    public boolean isInRange(Location location) {
        Location centerLoc = LocationConversion.convertLocationToCenterOfHexagon(location);
        return Math.pow(super.getStartLocation().getX() - centerLoc.getX(), 2)
                + Math.pow(super.getStartLocation().getY() - centerLoc.getY(), 2) < Math.pow(super.getRadius(), 2);
    }

    @Override
    public List<Location> getCoveredLocations() {
        

        return null;
    }

}
