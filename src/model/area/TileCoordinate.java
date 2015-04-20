package model.area;

import java.awt.geom.Point2D;

import utilities.Direction;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public class TileCoordinate implements Saveable {
	private int x;
	private int y;

	public TileCoordinate() {
		x = 1;
		y = 1;
	}

	public TileCoordinate(StructuredMap map) {
		this.x = map.getInteger("x");
		this.y = map.getInteger("y");
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
	
	public double getDistance(TileCoordinate dest){
    	return Point2D.distance(this.getX(), this.getY(), dest.getX(), dest.getY());
    	
    }

	public static RealCoordinate convertToRealCoordinate(TileCoordinate coord) {
		double x = (0.75 * coord.getX());
		double y = (Math.sqrt(3) / 2 * coord.getY()) + (((double) coord
				.getX() % 2) * Math.sqrt(3.0) / 4.0);
		return new RealCoordinate(x, y);
	}

	public TileCoordinate nextLocation(Direction angle) {
		return angle.nextLocation(this);
	}

	public TileCoordinate previousLocation(Direction angle) {
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

	public boolean nextTo(TileCoordinate target) {
		int difX = Math.abs(this.x - target.x);
		int difY = Math.abs(this.y - target.y);
		int difTotal = difX + difY;
		if (difX == 1 && difTotal == 2 && difY == 1) {
			return true;
		} else if (difTotal == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("x", this.x);
		map.put("y", this.y);
		return map;
	}
}
