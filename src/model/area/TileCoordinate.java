package model.area;

import utilities.Angle;

public class TileCoordinate {
	private int x;
    private int y;
    
    public TileCoordinate() {
    	x = 1;
    	y = 1;
    }

    public TileCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static RealCoordinate convertToRealCoordinate(TileCoordinate coord) {
        double x = (0.75 * coord.getX());
        double y = (double) ((Math.sqrt(3) / 2 * (double) coord.getY()) + (((double) coord.getX() % 2) * Math.sqrt(3.0) / 4.0));
        return new RealCoordinate(x, y);
    }

    public TileCoordinate nextLocation(Angle angle) {
    	return angle.nextLocation(this);
    }
    
    public TileCoordinate previousLocation(Angle angle) {
    	return angle.previousLocation(this);
    }
    
    @Override
    public String toString() {
    	return "(" + x + ", " + y + ")";
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		TileCoordinate other = (TileCoordinate) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
    
}
