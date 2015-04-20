package model.area;

import utilities.Direction;
import utilities.structuredmap.StructuredMap;

public abstract class DirectionalArea extends Area {

    public DirectionalArea(int radius, TileCoordinate startLocation, Direction angle) {
        super(radius, startLocation);
        setDirection(angle);
    }

    public DirectionalArea() {
        super();
        setDirection(Direction.UP);
    }

	public DirectionalArea(StructuredMap map) {
		super(map);
	}
}
