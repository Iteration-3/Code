package gameactions;

import model.area.TileCoordinate;
import model.map.GameMap;
import utilities.Direction;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.Camera;

public class GameActionGhostMovement extends GameAction implements Saveable {
	
	private Camera camera;
	private Direction direction;
	private GameMap terrain;

	public GameActionGhostMovement(Camera camera, GameMap terrain, Direction angle){
		this.camera = camera;
		this.terrain = terrain;
		this.direction = angle;
	}
	
	public GameActionGhostMovement(StructuredMap map) {
		this.direction = Direction.values()[map.getInteger("direction")];
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("direction", direction.ordinal());
		return map;
	}
	
	private boolean canMoveTo(TileCoordinate potentialSpot){
		return terrain.contains(potentialSpot);
	}
	
	@Override
	public void perform() {
		if (canMoveTo(camera.getMove(direction)))
			camera.move(direction);
	}
}