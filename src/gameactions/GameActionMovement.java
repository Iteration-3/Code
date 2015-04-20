package gameactions;

import model.area.TileCoordinate;
import model.entity.Entity;
import model.map.GameMap;
import model.map.ItemMap;
import utilities.Direction;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public class GameActionMovement extends GameAction implements Saveable {
	private Entity entity;
	private Direction direction;
	
	private GameMap terrain;
	private ItemMap itemMap;

	public GameActionMovement(Entity entity, GameMap terrain, ItemMap itemMap, Direction angle){

		this.entity = entity;
		this.terrain = terrain;
		this.direction = angle;
		this.itemMap = itemMap;
	}
	
	public GameActionMovement(StructuredMap map) {
		this.direction = Direction.values()[map.getInteger("direction")];
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("direction", direction.ordinal());
		return map;
	}
	
	public void setTarget(Entity entity){
		this.entity = entity;
	}
	

	protected GameMap getTerrain(){
		return terrain;
	}
	
	protected void setAngle(Direction a){
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
	
	protected Direction getDirection(){
		return direction;
	}
	
	@Override
	public void perform() {
		TileCoordinate potentialSpot = getEntity().nextLocation(direction);
		getEntity().setDirection(this.getDirection());
		this.getItemMap().touch(entity, potentialSpot);
		if(this.canMoveTo(potentialSpot)){
			getEntity().move(direction);
		}
	}



	
}
