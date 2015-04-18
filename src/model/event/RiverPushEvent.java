package model.event;

import gameactions.GameActionRiverPush;
import gameactions.GameActionTeleport;
import model.entity.Entity;

public class RiverPushEvent extends Event{
	private GameActionRiverPush gameActionRiverPush;
	public RiverPushEvent(GameActionRiverPush gameActionRiverPush) {
		super(0);
		this.gameActionRiverPush = gameActionRiverPush;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onExpired() {
		gameActionRiverPush.perform();
		
	}

	@Override
	public Event clone() {
		RiverPushEvent clone = new RiverPushEvent(this.getGameActionRiverPush());
		return clone;
	}

	private GameActionRiverPush getGameActionRiverPush() {
		return gameActionRiverPush;
	}

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		
	}

}
