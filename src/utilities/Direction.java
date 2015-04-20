package utilities;

import model.area.TileCoordinate;

public enum Direction {
    UP_RIGHT(1, -1, 0, 0),
    UP(0, -1, -1, 60),
    UP_LEFT(-1, -1, 0, 120),
    DOWN_LEFT(-1, 0, 1, -180),
    DOWN(0, 1, 1, -120),
    DOWN_RIGHT(1, 0, 1, -60),
    PRODUCE_A_ANGLE();
    
    private int deltaX;
    private int evenDeltaY;
    private int oddDeltaY;
    private int theta;
    

    private Direction(int deltaX, int evenDeltaY, int oddDeltaY, int theta) {
    	this.deltaX = deltaX;
    	this.evenDeltaY = evenDeltaY;
    	this.oddDeltaY = oddDeltaY;
    	this.theta = theta;
    }
    
    private Direction(){}

    public Direction getLeft() {
        Direction[] values = Direction.values();
        return values[(ordinal() - 1 + values.length) % values.length];
    }

    public Direction getRight() {
        Direction[] values = Direction.values();
        return Direction.values()[(ordinal() + 1) % values.length];
    }
    
    public int getAngle() {
    	return theta;
    }

    public Direction getNearestAngleTowardTarget(TileCoordinate startingLocation, TileCoordinate targetLocation){
		int chosenX = startingLocation.getX();
		int chosenY = startingLocation.getY();
		int targetX = targetLocation.getX();
		int targetY = targetLocation.getY();
		
		if (targetX < chosenX && targetY > chosenY ){
			return Direction.DOWN_LEFT;
		}
		else if (targetX > chosenX && targetY < chosenY){
			return Direction.UP_RIGHT;
		}
		else if (targetX < chosenX && targetY < chosenY){
			return Direction.UP_LEFT;
		}
		else if (targetX > chosenX && targetY > chosenY){
			return Direction.DOWN_RIGHT;
		}
		else if (targetY < chosenY){
			return Direction.UP;
		}
		else if (targetY > chosenY){
			return Direction.DOWN;
		}
		else if (targetX > chosenX){
			return Direction.UP_RIGHT;
		}
		else if (targetX < chosenX){
			return Direction.UP_LEFT;
		}
		else{
			return null;    // dont move
		}
    }
    
    public Direction getFarthestAngleFromTarget(TileCoordinate startingLocation, TileCoordinate targetLocation){
		int chosenX = startingLocation.getX();
		int chosenY = startingLocation.getY();
		int targetX = targetLocation.getX();
		int targetY = targetLocation.getY();

		if (targetX < chosenX && targetY > chosenY ){
			return Direction.UP_RIGHT;
		}
		else if (targetX > chosenX && targetY < chosenY){
			return Direction.DOWN_LEFT;
		}
		else if (targetX < chosenX && targetY < chosenY){
			return Direction.DOWN_RIGHT;
		}
		else if (targetX > chosenX && targetY > chosenY){
			return Direction.UP_LEFT;
		}
		else if (targetY < chosenY){
			return Direction.DOWN;
		}
		else if (targetY > chosenY){
			return Direction.UP;
		}
		else if (targetX > chosenX){
			return Direction.DOWN_LEFT;
		}
		else if (targetX < chosenX){
			return Direction.DOWN_RIGHT;
		}
		else{
			return null;    // dont move
		}
    }
    
    public TileCoordinate nextLocation(TileCoordinate tileCoordinate) {
    	int x = tileCoordinate.getX();
    	int y = tileCoordinate.getY();
    	return new TileCoordinate(x + deltaX(), y + deltaY(tileCoordinate));
    }
    
    public TileCoordinate previousLocation(TileCoordinate tileCoordinate) {
    	int x = tileCoordinate.getX();
    	int y = tileCoordinate.getY();
    	return new TileCoordinate(x - deltaX(), y + deltaY(tileCoordinate));
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
