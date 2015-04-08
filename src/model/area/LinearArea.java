package model.area;

import java.util.List;

public class LinearArea extends DirectionalArea {

    public LinearArea(int radius, Location location, Angle angle) {
        super(radius, location, angle);
    }

    public LinearArea() {
        super();
    }

    @Override
    public boolean isInRange(Location location) {
        return false;
    }

    @Override
    public List<Location> getCoveredLocations() {
        // TODO Auto-generated method stub
        return null;
    }

}
