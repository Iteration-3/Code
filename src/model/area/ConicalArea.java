package model.area;

import java.util.List;

import utilities.AreaAngle;

public class ConicalArea extends DirectionalArea {

    // Cone is always 60 degrees
    private static final int CONE_WIDTH_IN_DEGREES = 60;

    public ConicalArea() {
        super();
    }

    public ConicalArea(int radius, Location startLocation, AreaAngle angle) {
        super(radius, startLocation, angle);
    }

    @Override
    public boolean isInRange(Location location) {
        Location testLocation = super.createComparisonLocation(location);

        double angle = Math.toDegrees(Math.atan2((testLocation.getY()), testLocation.getX()));

        return angle >= super.getDirection().getAngle()
                && angle <= (super.getDirection().getAngle() + CONE_WIDTH_IN_DEGREES)
                && isWithinRadius(centerLocation(location));
    }

    @Override
    public List<Location> getCoveredLocations() {
        // TODO Auto-generated method stub
        return null;
    }

}
