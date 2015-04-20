package gameactions;

import model.area.TileCoordinate;
import model.entity.Entity;
import model.map.GameTerrain;
import model.map.ItemMap;
import utilities.Direction;

public class GameActionTeleport extends GameActionMovement {
	
	TileCoordinate potentialSpot = null;
	
	public GameActionTeleport(Entity entity, GameTerrain terrain,
			ItemMap itemMap, Direction angle) {
		super(entity, terrain, itemMap, angle);
		// TODO Auto-generated constructor stub
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
