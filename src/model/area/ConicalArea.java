package model.area;

import java.util.ArrayList;
import java.util.List;

import utilities.AreaAngle;
import utilities.structuredmap.StructuredMap;

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

    @Override
    public StructuredMap getStructuredMap() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void load(StructuredMap map) {
        // TODO Auto-generated method stub

    }

}
