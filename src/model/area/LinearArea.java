package model.area;

import java.util.ArrayList;
import java.util.List;

import utilities.Angle;
import utilities.structuredmap.StructuredMap;

public class LinearArea extends DirectionalArea {

    private static final int ANGLE_OFFSET = 30;

    public LinearArea(int radius, TileCoordinate location, Angle angle) {
        super(radius, location, angle);
    }

    public LinearArea() {
        super();
    }
    
    public LinearArea(StructuredMap map) {
    	super(map);
    }

    @Override
    public boolean isInRange(TileCoordinate location) {
        return getCoveredLocations().contains(location);
    }

    @Override
    public List<TileCoordinate> getCoveredLocations() {
        List<TileCoordinate> returnList = new ArrayList<TileCoordinate>();
        returnList.add(getStartLocation());
        for (int i = 1; i <= getRadius(); i++) {
        	returnList.add(returnList.get(returnList.size()-1).nextLocation(getDirection()));
        }
        return returnList;
    }

	@Override
	protected String getType() {
		return "linear";
	}

 


}
