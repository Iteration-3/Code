package model.area;

import java.util.List;

import utilities.LocationConversion;
import utilities.structuredmap.StructuredMap;

public class RadialArea extends Area {

    public RadialArea() {
        super();
    }

    public RadialArea(int radius, Location startLocation) {
        super(radius, startLocation);
    }

    @Override
    public boolean isInRange(Location location) {
        Location centerLoc = LocationConversion.convertLocationToCenterOfHexagon(location);
        return isWithinRadius(centerLoc);
    }

    @Override
    public List<Location> getCoveredLocations() {

        return null;
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
