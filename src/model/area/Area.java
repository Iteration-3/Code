package model.area;

import java.util.ArrayList;
import java.util.List;

import utilities.Angle;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public abstract class Area implements Saveable {
    private int range;
    private TileCoordinate startLocation;
    private Area compositeArea;

    public static final double WIDTH = 1.0;
    public static final double HEIGHT = Math.sqrt(3) / 2.0;

    public Area(int radius, TileCoordinate startLocation) {
        this.range = radius;
        this.startLocation = startLocation;
    }

    public Area() {
        this.range = 1;
        this.startLocation = new TileCoordinate();
    }

    public TileCoordinate getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(TileCoordinate startLocation) {
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

    protected List<TileCoordinate> getCompositeCoveredLocations() {
        List<TileCoordinate> emptyList = new ArrayList<>();

        return hasCompositeArea() ? compositeArea.getCoveredLocations() : emptyList;
    }

    public abstract boolean isInRange(TileCoordinate location);

    protected boolean isWithinRadius(TileCoordinate loc) {

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

    protected List<TileCoordinate> checkSurrounding(TileCoordinate location, List<TileCoordinate> returnList) {
        List<TileCoordinate> testLocations = new ArrayList<>();
        for (Angle angle : Angle.values()) {
            int xOffset = (int) Math.round(Area.HEIGHT * Math.cos(Math.toRadians(angle.getAngle() + 30)));
            int yOffset = (int) Math.round(Area.HEIGHT * Math.sin(Math.toRadians(angle.getAngle() + 30)));

            TileCoordinate testLocation = new TileCoordinate(location.getX() + xOffset, location.getY() - yOffset);

            if (canAdd(testLocation, returnList)) {
                returnList.add(testLocation);
            }
        }
        return testLocations;

    }

    protected boolean compositeInRange(TileCoordinate location) {
        return this.compositeArea.isInRange(location);
    }

    private boolean canAdd(TileCoordinate location, List<TileCoordinate> locations) {
        return !locations.contains(location) && isInRange(location);
    }

    public abstract List<TileCoordinate> getCoveredLocations();

    public abstract StructuredMap getStructuredMap();

    public abstract void load(StructuredMap map);
}
