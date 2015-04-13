package model.area;

import java.util.ArrayList;
import java.util.List;

import utilities.Angle;
import utilities.structuredmap.SavableLoadable;
import utilities.structuredmap.StructuredMap;

public abstract class Area implements SavableLoadable {
    private int range;
    private RealCoordinate startLocation;
    private Area compositeArea;

    public static final double WIDTH = 1.0;
    public static final double HEIGHT = Math.sqrt(3) / 2.0;

    public Area(int radius, RealCoordinate startLocation) {
        this.range = radius;
        this.startLocation = startLocation;
    }

    public Area() {
        this.range = 1;
        this.startLocation = new RealCoordinate();
    }

    public RealCoordinate getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(RealCoordinate startLocation) {
        this.startLocation = startLocation;
    }

    public int getRadius() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void addCompositeArea(Area area) {
        this.compositeArea = area;
    }

    public Area getCompositeArea(Area area) {
        return this.compositeArea;
    }

    protected boolean hasCompositeArea() {
        return this.compositeArea != null;
    }

    protected List<RealCoordinate> getCompositeCoveredLocations() {
        List<RealCoordinate> emptyList = new ArrayList<>();

        return hasCompositeArea() ? compositeArea.getCoveredLocations() : emptyList;
    }

    public abstract boolean isInRange(RealCoordinate location);

    protected boolean isWithinRadius(RealCoordinate loc) {
        loc = convertToCenter(loc);

        return withinOffset(
                Math.pow(getStartLocation().getX() - loc.getX(), 2)
                        + Math.pow(getStartLocation().getY() - loc.getY(), 2),
                Math.pow(((getRadius() - 1) * Area.HEIGHT), 2), .2)
                || lessThan(
                        Math.pow(getStartLocation().getX() - loc.getX(), 2)
                                + Math.pow(getStartLocation().getY() - loc.getY(), 2),
                        Math.pow(((getRadius() - 1) * Area.HEIGHT), 2));

    }

    private boolean lessThan(double double1, double double2) {
        return double1 <= double2;
    }

    private boolean withinOffset(double double1, double double2, double offset) {
        return Math.abs(double1 - double2) <= offset;
    }

    protected RealCoordinate convertToCenter(RealCoordinate loc) {
        return TileCoordinate.convertToRealCoordinate(RealCoordinate.convertToTileCoordinate(loc));
    }

    protected List<RealCoordinate> checkSurrounding(RealCoordinate location, List<RealCoordinate> returnList) {
        List<RealCoordinate> testLocations = new ArrayList<>();
        location = convertToCenter(location);
        for (Angle angle : Angle.values()) {
            double xOffset = Math.round(Area.HEIGHT * Math.cos(Math.toRadians(angle.getAngle() + 30)));
            double yOffset = Math.round(Area.HEIGHT * Math.sin(Math.toRadians(angle.getAngle() + 30)));

            RealCoordinate testLocation = new RealCoordinate(location.getX() + xOffset, location.getY() - yOffset);
            testLocation = convertToCenter(testLocation);

            if (canAdd(testLocation, returnList)) {
                returnList.add(testLocation);
            }
        }
        return testLocations;

    }

    protected boolean compositeInRange(RealCoordinate location) {
        return this.compositeArea.isInRange(location);
    }

    private boolean canAdd(RealCoordinate location, List<RealCoordinate> locations) {
        return !locations.contains(location) && isInRange(location);
    }

    public abstract List<RealCoordinate> getCoveredLocations();

    public abstract StructuredMap getStructuredMap();

    public abstract void load(StructuredMap map);
}
