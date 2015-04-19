package model.area;

import utilities.Angle;
import utilities.structuredmap.StructuredMap;

public abstract class DirectionalArea extends Area {

    public DirectionalArea(int radius, TileCoordinate startLocation, Angle angle) {
        super(radius, startLocation);
        setDirection(angle);
    }

    public DirectionalArea() {
        super();
        setDirection(Angle.UP);
    }

	public DirectionalArea(StructuredMap map) {
		super(map);
	}
}
