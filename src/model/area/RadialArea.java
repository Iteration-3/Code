package model.area;

import java.util.List;

public class RadialArea extends Area {

    public RadialArea() {
        super();
    }

    public RadialArea(int radius, Location startLocation) {
        super(radius, startLocation);
    }

    @Override
    public boolean isInRange(Location location) {
        return false;
    }

    @Override
    public List<Location> getCoveredLocations() {
        

        return null;
    }

}
