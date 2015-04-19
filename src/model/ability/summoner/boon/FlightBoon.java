package model.ability.summoner.boon;

import model.ability.SelfAbility;
import model.entity.Avatar;
import model.event.FlightEvent;
import utilities.structuredmap.StructuredMap;

public class FlightBoon extends SelfAbility{
	final static int defaultDuration = 10;//Instead of constants for now. 
	final static int defaultManaCost = 15;
	public FlightBoon(){
		super(new FlightEvent(defaultDuration),defaultManaCost);
	}
	
	public FlightBoon(int manacost, int duration){
		super(new FlightEvent(duration),manacost);
	}
	
	public FlightBoon(StructuredMap map) {
		super(map);
	}
	
	@Override
	public void perform(Avatar avatar){
		if(avatar.isFlying()){return;}//You can't fly while flying!
		super.perform(avatar);
	}

	@Override
	protected String getType() {
		return "flightBoon";
	}

}
