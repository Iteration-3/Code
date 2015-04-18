package model.event;

import gameactions.GameActionTeleport;
import model.area.TileCoordinate;
import model.entity.Entity;

public class TeleportEvent extends Event {

	private GameActionTeleport teleportAction;

	public TeleportEvent(double duration,TileCoordinate location, GameActionTeleport teleportAction) {
		super(duration);
		this.teleportAction = teleportAction;
		this.teleportAction.setTeleportToLocation(location);
		// TODO Auto-generated constructor stub
	}
	
	public TeleportEvent(double duration, GameActionTeleport teleportAction) {
		super(duration);
		this.teleportAction = teleportAction;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void perform() {
		if(teleportAction.hasLocation()){
			teleportAction.perform();
		}
		
	}

	@Override
	public Event clone() {
		TeleportEvent clone = new TeleportEvent(this.getDuration(),teleportAction);
		return clone;
	}

}
