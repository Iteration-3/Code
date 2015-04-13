package model.area;

import java.util.ArrayList;
import java.util.List;

import utilities.Angle;
import utilities.LocationConversion;
import utilities.structuredmap.SavableLoadable;
import utilities.structuredmap.StructuredMap;

public abstract class Area implements SavableLoadable {
    private int range;
    private RealCoordinate startLocation;
    private Area compositeArea;

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
        double radiusMultiplier = LocationConversion.getRadius();

        return Math.pow(getStartLocation().getX() - loc.getX(), 2)
                + Math.pow(getStartLocation().getY() - loc.getY(), 2) <= Math.pow(
                ((getRadius() - 1) * radiusMultiplier), 2);
    }

    protected List<RealCoordinate> checkSurrounding(RealCoordinate location, List<RealCoordinate> returnList) {
        List<RealCoordinate> testLocations = new ArrayList<>();
        double height = LocationConversion.getHeight();

        for (Angle angle : Angle.values()) {
            double xOffset = Math.round(height * Math.cos(Math.toRadians(angle.getAngle() + 30)));
            double yOffset = Math.round(height * Math.sin(Math.toRadians(angle.getAngle() + 30)));
            RealCoordinate testLocation = new RealCoordinate(location.getX() + xOffset, location.getY() - yOffset);

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
