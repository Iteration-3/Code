package model.area;

import java.util.List;

import utilities.Direction;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public abstract class Area implements Saveable {
	
    private int range;
    private TileCoordinate startLocation;
    private Direction direction;
    protected List<TileCoordinate> prevCovered;

    public static final double WIDTH = 1.0;
    public static final double HEIGHT = Math.sqrt(3) / 2.0;

    public Area(int radius, TileCoordinate startLocation) {
        this.range = radius;
        this.startLocation = startLocation;
        this.direction = Direction.UP;
    }

    public Area() {
        this.range = 1;
        this.startLocation = new TileCoordinate();
        this.direction = Direction.UP;
    }
    
    public Area(StructuredMap map) {
    	this.range = map.getInteger("range");
    	int[] location = map.getIntArray("coordinate");
    	this.startLocation = new TileCoordinate(location[0], location[1]);
    	this.direction = Direction.values()[map.getInteger("direction")];
    }

    @Override
	public StructuredMap getStructuredMap() {
    	StructuredMap map = new StructuredMap();
    	int[] location = new int[2];
    	location[0] = startLocation.getX();
    	location[1] = startLocation.getY();
    	map.put("range", range);
    	map.put("coordinate", location);
    	map.put("type", getType());
    	map.put("direction", direction.ordinal());
    	return map;
    }
    
    protected abstract String getType();

	public TileCoordinate getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(TileCoordinate startLocation) {
    	if (this.startLocation != null) {
    		prevCovered = getCoveredLocations();
    	}
        this.startLocation = startLocation;
    }
    
    public List<TileCoordinate> getPrevCoveredLocations() {
    	List<TileCoordinate> prev = prevCovered;
    	prevCovered = null;
    	return prev;
    }

    public int getRadius() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public abstract boolean isInRange(TileCoordinate location);

    protected boolean isWithinRadius(TileCoordinate loc) {
        return getCoveredLocations().contains(loc);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public abstract List<TileCoordinate> getCoveredLocations();
}
