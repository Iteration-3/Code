package model.area;

import java.util.ArrayList;
import java.util.List;

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
        return isWithinRadius(location);
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
