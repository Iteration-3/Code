package model.event;

import gameactions.GameActionRiverPush;
import model.entity.Entity;
import utilities.structuredmap.StructuredMap;

public class RiverPushEvent extends Event{
	private GameActionRiverPush gameActionRiverPush;
	
	public RiverPushEvent(GameActionRiverPush gameActionRiverPush) {
		super(0);
		this.gameActionRiverPush = gameActionRiverPush;
		// TODO Auto-generated constructor stub
	}
	
	public RiverPushEvent(StructuredMap map) {
		super(map);
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

	@Override
	protected String getType() {
		return "riverPush";
	}

}
