package model.area;

import java.util.ArrayList;
import java.util.List;

import utilities.structuredmap.StructuredMap;

public class RadialArea extends Area {

    public RadialArea() {
        super();
    }

    public RadialArea(int radius, RealCoordinate startLocation) {
        super(radius, startLocation);
    }

    @Override
    public boolean isInRange(RealCoordinate location) {
        return super.hasCompositeArea() ? isWithinRadius(location) || super.compositeInRange(location)
                : isWithinRadius(location);
    }

    @Override
    public List<RealCoordinate> getCoveredLocations() {
        List<RealCoordinate> returnList = new ArrayList<>();
        returnList.add(super.convertToCenter(super.getStartLocation()));
        int i = 0;
        while (i != returnList.size()) {
            returnList.addAll(checkSurrounding(returnList.get(i), returnList));
            ++i;
        }
        returnList.addAll(getCompositeCoveredLocations());
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
