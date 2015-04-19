package model.area;

import java.util.ArrayList;
import java.util.List;

import factories.AreaFactory;
import utilities.Angle;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public abstract class Area implements Saveable {
    private int range;
    private TileCoordinate startLocation;
    private Area compositeArea;    
    private Angle direction;

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
    
    public Area(StructuredMap map) {
    	this.range = map.getInteger("range");
    	int[] location = map.getIntArray("coordinate");
    	this.startLocation = new TileCoordinate(location[0], location[1]);
    	this.compositeArea = AreaFactory.createArea(map.getStructuredMap("area"));
    	this.direction = Angle.values()[map.getInteger("direction")];
    }

    public StructuredMap getStructuredMap() {
    	StructuredMap map = new StructuredMap();
    	int[] location = new int[2];
    	location[0] = startLocation.getX();
    	location[1] = startLocation.getY();
    	map.put("range", range);
    	map.put("coordinate", location);
    	map.put("compositeArea", compositeArea.getStructuredMap());
    	map.put("type", getType());
    	map.put("direction", direction.ordinal());
    	return map;
    }
    
    protected abstract String getType();

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

        return getCoveredLocations().contains(loc);

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

    public Angle getDirection() {
        return direction;
    }

    public void setDirection(Angle direction) {
        this.direction = direction;
    }

    protected boolean compositeInRange(TileCoordinate location) {
        return this.compositeArea.isInRange(location);
    }

    private boolean canAdd(TileCoordinate location, List<TileCoordinate> locations) {
        return !locations.contains(location) && isInRange(location);
    }

    public abstract List<TileCoordinate> getCoveredLocations();

    

    
}
