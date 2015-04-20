package gameactions;

import model.entity.Entity;
import model.map.GameMap;
import model.map.ItemMap;
import utilities.Angle;

public class GameActionRiverPush extends GameAction {
	GameActionTeleport teleport;
	Entity entity;

	public GameActionRiverPush(Entity entity, GameMap terrain,
			ItemMap itemMap, Angle angle) {
		teleport = new GameActionTeleport(entity, terrain, itemMap, angle);
		this.entity = entity;
		// TODO Auto-generated constructor stub
	}
	
	public void setAngle(Angle a){
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
