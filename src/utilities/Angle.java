package utilities;

import model.area.TileCoordinate;

public enum Angle {
    UP_RIGHT(1, -1, 0, 0),
    UP(0, -1, -1, 60),
    UP_LEFT(-1, -1, 0, 120),
    DOWN_LEFT(-1, 0, 1, -180),
    DOWN(0, 1, 1, -120),
    DOWN_RIGHT(1, 0, 1, -60);
    
    private int deltaX;
    private int evenDeltaY;
    private int oddDeltaY;
    private int theta;

    private Angle(int deltaX, int evenDeltaY, int oddDeltaY, int theta) {
    	this.deltaX = deltaX;
    	this.evenDeltaY = evenDeltaY;
    	this.oddDeltaY = oddDeltaY;
    	this.theta = theta;
    }

    public Angle getLeft() {
        Angle[] values = Angle.values();
        return values[(ordinal() - 1 + values.length) % values.length];
    }

    public Angle getRight() {
        Angle[] values = Angle.values();
        return Angle.values()[(ordinal() + 1) % values.length];
    }
    
    public int getAngle() {
    	return theta;
    }
    
    public TileCoordinate nextLocation(TileCoordinate tileCoordinate) {
    	int x = tileCoordinate.getX();
    	int y = tileCoordinate.getY();
    	return new TileCoordinate(x + deltaX(), y + deltaY(tileCoordinate));
    }
    
    private int deltaX() {
    	return deltaX;
    }
    
    private int deltaY(TileCoordinate tileCoordinate)  {
    	if (tileCoordinate.getX() % 2 == 0) {
    		return evenDeltaY;
    	} else {
    		return oddDeltaY;
    	}
    }
    
    @Override
    public String toString() {
    	switch(this) {
		case DOWN:
			return "DOWN";
		case DOWN_LEFT:
			return "DOWN_LEFT";
		case DOWN_RIGHT:
			return "DOWN_RIGHT";
		case UP:
			return "UP";
		case UP_LEFT:
			return "UP_LEFT";
		case UP_RIGHT:
			return "UP_RIGHT";
		default:
			return "ERROR_NO_DIRECTION";
    	}
    }
}
