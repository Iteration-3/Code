package model.area;

import java.util.List;

import utilities.Angle;

public class ConicalArea extends DirectionalArea {

    public ConicalArea() {
        super();
    }

    public ConicalArea(int radius, Location startLocation, Angle angle) {
        super(radius, startLocation, angle);
    }

    @Override
    public boolean isInRange(Location location) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Location> getCoveredLocations() {
        // TODO Auto-generated method stub
        return null;
    }

}
