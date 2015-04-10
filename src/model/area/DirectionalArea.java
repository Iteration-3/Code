package model.area;

import java.util.ArrayList;
import java.util.List;

import utilities.AreaAngle;
import utilities.LocationConversion;

public abstract class DirectionalArea extends Area {

    private AreaAngle direction;

    public DirectionalArea(int radius, Location startLocation, AreaAngle angle) {
        super(radius, startLocation);
        this.direction = angle;
    }

    public DirectionalArea() {
        super();
        this.direction = AreaAngle.UP;
    }

    public AreaAngle getDirection() {
        return direction;
    }

    public void setDirection(AreaAngle direction) {
        this.direction = direction;
    }

    @Override
    public abstract boolean isInRange(Location location);

    @Override
    public abstract List<Location> getCoveredLocations();

    protected Location createComparisonLocation(Location location) {
        //Location centerLoc = centerLocation(location);

        Location testLocation = new Location((location.getX() - super.getStartLocation().getX()),
                ((-1 * location.getY()) + super.getStartLocation().getY()));

        return testLocation;
    }

    protected Location centerLocation(Location location) {
        return LocationConversion.convertLocationToCenterOfHexagon(location);
    }

    protected List<Location> locationsInALine(double angle, int radius, Location location) {
        List<Location> returnList = new ArrayList<>();
        for (int i = 0; i < getRadius(); i++) {
            double testAngle = angle + 30;
            int xMultiplier = Math.cos(Math.toRadians(testAngle)) > 0.01 ? 1 : withinBounds(Math.cos(Math
                    .toRadians(testAngle))) ? 0 : -1;

            int yMultiplier = Math.sin(Math.toRadians(testAngle)) > 0.01 ? -1 : withinBounds(Math.sin(Math
                    .toRadians(testAngle))) ? 0 : 1;

            double x = location.getX() + ((LocationConversion.getWidth() * i * 0.75) * xMultiplier);
            double y = location.getY() + ((LocationConversion.getHeight() * i * 0.5) * yMultiplier);

            returnList.add(new Location(x, y));
        }
        return returnList;
    }
    
    private boolean withinBounds(double value) {
        return value < 0.01 && value > -0.01;
    }

    /**
     * Uncomment when structure map comes in.
     * 
     * @Override public abstract StructuredMap save();
     * @Override public abstract Area load(StructuredMap map);
     */
}
