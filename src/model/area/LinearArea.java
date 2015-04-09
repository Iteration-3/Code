package model.area;

import java.util.List;

import utilities.AreaAngle;
import utilities.LocationConversion;

public class LinearArea extends DirectionalArea {

    private static final int ANGLE_OFFSET_TO_CENTER = 30;

    public LinearArea(int radius, Location location, AreaAngle angle) {
        super(radius, location, angle);
    }

    public LinearArea() {
        super();
    }

    @Override
    public boolean isInRange(Location location) {
        Location centerLoc = LocationConversion.convertLocationToCenterOfHexagon(location);
        int angle = (int) Math.round(Math.toDegrees(Math.atan2(centerLoc.getY(), centerLoc.getX())));
        System.out.println(angle);
        return angle == (super.getDirection().getAngle() + ANGLE_OFFSET_TO_CENTER) && super.isWithinRadius(centerLoc);
    }

    @Override
    public List<Location> getCoveredLocations() {
        // TODO Auto-generated method stub
        return null;
    }

}
