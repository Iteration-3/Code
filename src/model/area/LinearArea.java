package model.area;

import java.util.List;

import utilities.AreaAngle;

public class LinearArea extends DirectionalArea {

    private static final int UP_DOWN_OFFSET = 30;
    private static final int UP_R_DOWN_L_OFFSET = 41;
    private static final int UP_L_DOWN_R_OFFSET = 19;

    public LinearArea(int radius, Location location, AreaAngle angle) {
        super(radius, location, angle);
    }

    public LinearArea() {
        super();
    }

    /**
     * Not a fan of this but whatever for now. Should work for regular hexagons. If it doesn't
     * just yell at Kyle.
     */
    @Override
    public boolean isInRange(Location location) {
        Location testLocation = super.createComparisonLocation(location);
        int angle = (int) (Math.round(Math.toDegrees(Math.atan2((testLocation.getY()), testLocation.getX()))));

        /**
         * Not a fan of this but whatever for now.
         */
        int angleOffset = (super.getDirection() == AreaAngle.UP || super.getDirection() == AreaAngle.DOWN) ? UP_DOWN_OFFSET
                : (super.getDirection() == AreaAngle.DOWN_LEFT || super.getDirection() == AreaAngle.UP_RIGHT) ? UP_R_DOWN_L_OFFSET
                        : UP_L_DOWN_R_OFFSET;

        return angle == (super.getDirection().getAngle() + angleOffset)
                && super.isWithinRadius(centerLocation(location));
    }

    @Override
    public List<Location> getCoveredLocations() {
        // TODO Auto-generated method stub
        return null;
    }

}
