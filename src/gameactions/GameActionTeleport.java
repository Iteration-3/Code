package gameactions;

import model.area.TileCoordinate;
import model.entity.Entity;
import model.map.GameMap;
import model.map.ItemMap;
import utilities.Direction;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public class GameActionTeleport extends GameActionMovement implements Saveable {
	
	TileCoordinate potentialSpot = null;

	public GameActionTeleport(Entity entity, GameMap terrain,
			ItemMap itemMap, Direction angle) {

		super(entity, terrain, itemMap, angle);
		// TODO Auto-generated constructor stub
	}
	
	public GameActionTeleport(StructuredMap map) {
		super(map);
		this.potentialSpot = map.getStructuredMap("coordinate") == null ? null : new TileCoordinate(map.getStructuredMap("coordinate"));
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("coordinate", potentialSpot == null ? null : potentialSpot.getStructuredMap());
		return map;
	}
	
	public void setTeleportToLocation(TileCoordinate potentialSpot) {
		this.potentialSpot = potentialSpot;
	}
	
	@Override
	public void setAngle(Direction angle) {
		super.setAngle(angle);
	}
	
	@Override
	public Direction getDirection() {
		return super.getDirection();
	}
	
	public boolean hasLocation() {
		return !(potentialSpot==null);
	}
	
	@Override
	public void perform(){
		if(this.canMoveTo(potentialSpot)) {
			this.getEntity().setLocation(potentialSpot);
			this.getItemMap().touch(this.getEntity(), potentialSpot);
			this.getEntity().setDirection(this.getDirection());
		}
	}

	

}
