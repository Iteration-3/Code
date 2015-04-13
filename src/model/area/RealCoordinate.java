package model.area;

import utilities.Angle;

public class RealCoordinate {
    private double x;
    private double y;

    // defaults constructor to 0
    public RealCoordinate() {
        this.x = 0;
        this.y = 0;
    }

    public RealCoordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public RealCoordinate nextLocation(Angle angle) {
    	int xDisplacement = 0, yDisplacement = 0;
    	if (angle == Angle.UP_RIGHT || angle == Angle.UP || angle == Angle.UP_LEFT) {
    		yDisplacement = -1;
    	} else {
    		yDisplacement = 1;
    	}
    	if (angle == Angle.UP_RIGHT || angle == Angle.DOWN_RIGHT) {
    		xDisplacement = 1;
    	} else if (angle == Angle.UP_LEFT || angle == Angle.UP_RIGHT) {
    		xDisplacement = -1;
    	}
    	return new RealCoordinate(xDisplacement, yDisplacement);
    }
    
    public static TileCoordinate convertToTileCoordinate(RealCoordinate coord) {
        return null;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RealCoordinate other = (RealCoordinate) obj;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
            return false;
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
            return false;
        return true;
    }

    
}
