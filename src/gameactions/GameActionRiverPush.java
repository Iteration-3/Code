package gameactions;

import model.entity.Entity;
import model.map.GameMap;
import model.map.ItemMap;
import utilities.Direction;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public class GameActionRiverPush extends GameAction implements Saveable {
	GameActionTeleport teleport;
	Entity entity;

	public GameActionRiverPush(Entity entity, GameMap terrain,
			ItemMap itemMap, Direction angle) {
		teleport = new GameActionTeleport(entity, terrain, itemMap, angle);
		this.entity = entity;
		// TODO Auto-generated constructor stub
	}
	
	public GameActionRiverPush(StructuredMap map) {
		teleport = new GameActionTeleport(map.getStructuredMap("teleport"));
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("teleport", teleport.getStructuredMap());
		return map;
	}
	
	
	public void setAngle(Direction a){
		teleport.setAngle(a);
	}
	
	@Override
	public void perform() {
		teleport.setTeleportToLocation(entity.nextLocation(teleport.getDirection()));
		teleport.perform();
		
	}

	public void setTarget(Entity entity) {
		teleport.setTarget(entity);
	}

	
	

}
