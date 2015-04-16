package gameactions;

import utilities.Angle;
import model.area.RealCoordinate;
import model.entity.Entity;
import model.map.GameTerrain;

public class GameActionMovement extends GameAction {
	private Entity entity;
	private Angle direction;

	private GameTerrain terrain;

	public GameActionMovement(Entity entity, GameTerrain terrain, Angle angle){
		this.entity = entity;
		this.terrain = terrain;
		this.direction = angle;
	}
	

	protected GameTerrain getTerrain(){
		return terrain;
	}
	
	protected Entity getEntity(){
		return entity;
	}
	
	@Override
	public void perform() {
		RealCoordinate potentialSpot = getEntity().getSpotToMoveTo(direction);
		if(getTerrain().isPassable(getEntity(), potentialSpot)){
			getEntity().move(potentialSpot,direction);
		}
	}
}
