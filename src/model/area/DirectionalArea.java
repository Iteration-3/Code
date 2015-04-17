package model.area;

import java.util.ArrayList;
import java.util.List;

import utilities.Angle;
import utilities.structuredmap.StructuredMap;

public abstract class DirectionalArea extends Area {

    private Angle direction;

    public DirectionalArea(int radius, TileCoordinate startLocation, Angle angle) {
        super(radius, startLocation);
        this.direction = angle;
    }

    public DirectionalArea() {
        super();
        this.direction = Angle.UP;
    }

    public Angle getDirection() {
        return direction;
    }

    public void setDirection(Angle direction) {
        this.direction = direction;
    }

    @Override
    public abstract boolean isInRange(TileCoordinate location);

    @Override
    public abstract List<TileCoordinate> getCoveredLocations();

    protected TileCoordinate createComparisonLocation(TileCoordinate location) {
        TileCoordinate testLocation = new TileCoordinate((location.getX() - super.getStartLocation().getX()),
                ((-1 * location.getY()) + super.getStartLocation().getY()));

        return testLocation;
    }

    protected List<TileCoordinate> locationsInALine(double angle, int radius, TileCoordinate location) {
        List<TileCoordinate> returnList = new ArrayList<>();
        for (int i = 0; i < getRadius(); i++) {
            double testAngle = angle + 30;
            int xMultiplier = Math.cos(Math.toRadians(testAngle)) > 0.01 ? 1 : withinBounds(Math.cos(Math
                    .toRadians(testAngle))) ? 0 : -1;

            int yMultiplier = Math.sin(Math.toRadians(testAngle)) > 0.01 ? -1 : withinBounds(Math.sin(Math
                    .toRadians(testAngle))) ? 0 : 1;

            double x = location.getX() + ((Area.WIDTH * i * 0.75) * xMultiplier);
            double y = location.getY() + ((Area.HEIGHT * i * 0.5) * yMultiplier);

            returnList.add(new TileCoordinate((int)x, (int)y));
        }
        return returnList;
    }

    private boolean withinBounds(double value) {
        return value < 0.01 && value > -0.01;
    }

    @Override
    public abstract StructuredMap getStructuredMap();

    @Override
    public abstract void load(StructuredMap map);
}
