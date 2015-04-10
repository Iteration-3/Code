package model.area;

import java.util.List;

import utilities.AreaAngle;

public class LinearArea extends DirectionalArea {

    private static final int ANGLE_OFFSET = 30;

    public LinearArea(int radius, Location location, AreaAngle angle) {
        super(radius, location, angle);
    }

    public LinearArea() {
        super();
    }

    /**
     * Not a fan of this but whatever for now. Should work for regular hexagons.
     * If it doesn't just yell at Kyle.
     */
    @Override
    public boolean isInRange(Location location) {
        Location testLocation = super.createComparisonLocation(location);
        int angle = (int) (Math.round(Math.toDegrees(Math.atan2((testLocation.getY()), testLocation.getX()))));

        return angle == (super.getDirection().getAngle() + ANGLE_OFFSET)
                && super.isWithinRadius(location);
    }

    @Override
    public List<Location> getCoveredLocations() {
        return super.locationsInALine(super.getDirection().getAngle(), super.getRadius(), super.getStartLocation());
    }
}
