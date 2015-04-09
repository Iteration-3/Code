package model.area;

import java.util.ArrayList;
import java.util.List;

import utilities.AreaAngle;
import utilities.LocationConversion;

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
     * Not a fan of this but whatever for now. Should work for regular hexagons.
     * If it doesn't just yell at Kyle.
     */
    @Override
    public boolean isInRange(Location location) {
        Location testLocation = super.createComparisonLocation(location);
        int angle = (int) (Math.round(Math.toDegrees(Math.atan2((testLocation.getY()), testLocation.getX()))));

        int angleOffset = (super.getDirection() == AreaAngle.UP || super.getDirection() == AreaAngle.DOWN) ? UP_DOWN_OFFSET
                : (super.getDirection() == AreaAngle.DOWN_LEFT || super.getDirection() == AreaAngle.UP_RIGHT) ? UP_R_DOWN_L_OFFSET
                        : UP_L_DOWN_R_OFFSET;

        return angle == (super.getDirection().getAngle() + angleOffset)
                && super.isWithinRadius(centerLocation(location));
    }

    @Override
    public List<Location> getCoveredLocations() {
        List<Location> returnList = new ArrayList<>();
        for (int i = 0; i < super.getRadius(); i++) {
            int angle = super.getDirection().getAngle() + 30;
            int xMultiplier = Math.cos(Math.toRadians(angle)) > 0.01 ? 1
                    : withinBounds(Math.cos(Math.toRadians(angle))) ? 0 : -1;

            int yMultiplier = Math.sin(Math.toRadians(angle)) > 0.01 ? -1 : withinBounds(Math
                    .sin(Math.toRadians(angle))) ? 0 : 1;

            double x = super.getStartLocation().getX() + ((LocationConversion.getWidth() * i) * xMultiplier);
            double y = super.getStartLocation().getY() + ((LocationConversion.getHeight() * i) * yMultiplier);

            returnList.add(LocationConversion.convertLocationToCenterOfHexagon(new Location(x, y)));
        }

        return returnList;
    }

    private boolean withinBounds(double value) {
        return value < 0.01 && value > -0.01;
    }

}
