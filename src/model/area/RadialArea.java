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
        return isWithinRadius(centerLoc);
    }

    @Override
    public List<Location> getCoveredLocations() {

        return null;
    }

}
