package model.event;

import gameactions.GameActionTeleport;
import model.area.TileCoordinate;

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

}
