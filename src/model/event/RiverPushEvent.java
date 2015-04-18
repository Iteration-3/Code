package model.event;

import gameactions.GameActionRiverPush;
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
	
	@Override
	public void setTarget(Entity entity){
		gameActionRiverPush.setTarget(entity);
		super.setTarget(entity);
	}

	private GameActionRiverPush getGameActionRiverPush() {
		return gameActionRiverPush;
	}

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		
	}

}
