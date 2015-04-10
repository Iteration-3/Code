package model.area;

import java.util.ArrayList;
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
        System.out.println("Angle: " + angle + " Loc: " + testLocation.getX() + " " + testLocation.getY());
        System.out.println(angle >= super.getDirection().getAngle());
        System.out.println(angle <= (super.getDirection().getAngle() + CONE_WIDTH_IN_DEGREES));
        System.out.println(isWithinRadius(location));
        return angle >= super.getDirection().getAngle()
                && angle <= (super.getDirection().getAngle() + CONE_WIDTH_IN_DEGREES) && isWithinRadius(location);
    }

    @Override
    public List<Location> getCoveredLocations() {
        List<Location> returnList = new ArrayList<>();
        returnList.add(super.getStartLocation());
        int i = 0;
        while (i != returnList.size()) {
            returnList.addAll(checkSurrounding(returnList.get(i), returnList));
            ++i;
        }
        return returnList;
    }

}
