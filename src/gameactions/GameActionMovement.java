package gameactions;

import model.area.TileCoordinate;
import model.entity.Entity;
import model.map.GameTerrain;
import model.map.ItemMap;
import utilities.Angle;

public class GameActionMovement extends GameAction {
	private Entity entity;
	private Angle direction;
	
	private GameTerrain terrain;
	private ItemMap itemMap;

	public GameActionMovement(Entity entity, GameTerrain terrain, ItemMap itemMap, Angle angle){
		this.entity = entity;
		this.terrain = terrain;
		this.direction = angle;
		this.itemMap = itemMap;
	}
	
	public void setTarget(Entity entity){
		this.entity = entity;
	}
	

	protected GameTerrain getTerrain(){
		return terrain;
	}
	
	protected void setAngle(Angle a){
		this.direction = a;
	}
	
	protected Entity getEntity(){
		return entity;
	}
	
	protected ItemMap getItemMap(){
		return itemMap;
	}
	
	protected boolean canMoveTo(TileCoordinate potentialSpot){
		return (getTerrain().isPassable(getEntity(), potentialSpot) && !getItemMap().isBlocking(potentialSpot));
	}
	
	protected Angle getDirection(){
		return direction;
	}
	
	@Override
	public void perform() {
		TileCoordinate potentialSpot = getEntity().nextLocation(direction);
		this.getItemMap().touch(entity, potentialSpot);
		if(this.canMoveTo(potentialSpot)){
			getEntity().move(direction);
		}
	}
}
