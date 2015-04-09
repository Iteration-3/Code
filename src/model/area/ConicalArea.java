package model.area;

import java.util.List;

import utilities.AreaAngle;
import utilities.LocationConversion;

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
        Location centerLoc = LocationConversion.convertLocationToCenterOfHexagon(location);
        
        Location testLocation = new Location((centerLoc.getX() - super.getStartLocation().getX()),
                ((-1 * centerLoc.getY()) + super.getStartLocation().getY()));
 
        double angle = Math.toDegrees(Math.atan2((testLocation.getY()), testLocation.getX()));
         
        return angle >= super.getDirection().getAngle()
                && angle <= (super.getDirection().getAngle() + CONE_WIDTH_IN_DEGREES) && isWithinRadius(centerLoc);
    }

    @Override
    public List<Location> getCoveredLocations() {
        // TODO Auto-generated method stub
        return null;
    }

}
