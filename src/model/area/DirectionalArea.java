package model.area;

import utilities.Angle;

public abstract class DirectionalArea extends Area {

    public DirectionalArea(int radius, TileCoordinate startLocation, Angle angle) {
        super(radius, startLocation);
        setDirection(angle);
    }

    public DirectionalArea() {
        super();
        setDirection(Angle.UP);
    }
}
