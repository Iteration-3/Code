package model.event;

import gameactions.GameActionTeleport;
import model.area.TileCoordinate;
import model.entity.Entity;
import utilities.structuredmap.StructuredMap;

public class TeleportEvent extends Event {

	private GameActionTeleport teleportAction;

	public TeleportEvent(TileCoordinate location, GameActionTeleport teleportAction) {
		super(0);
		this.teleportAction = teleportAction;
		this.teleportAction.setTeleportToLocation(location);
		// TODO Auto-generated constructor stub
	}
	
	public TeleportEvent(GameActionTeleport teleportAction) {
		super(0);
		this.teleportAction = teleportAction;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("teleportAction", teleportAction.getStructuredMap());
		return map;
	}
	
	public TeleportEvent(StructuredMap map) {
		super(map);
	}
	
	@Override
	public void setTarget(Entity entity){
		teleportAction.setTarget(entity);
		super.setTarget(entity);
	}

	@Override
	public void perform() {
		if(teleportAction.hasLocation()){
			teleportAction.perform();
		}
		
	}

	@Override
	public Event clone() {
		TeleportEvent clone = new TeleportEvent(teleportAction);
		return clone;
	}

	@Override
	protected String getType() {
		return "teleportEvent";
	}

}
