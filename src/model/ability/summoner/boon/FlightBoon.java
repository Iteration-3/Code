package model.ability.summoner.boon;

import model.ability.SelfAbility;
import model.event.FlightEvent;

public class FlightBoon extends SelfAbility{
	final static int defaultDuration = 10;//Instead of constants for now. 
	final static int defaultManaCost = 15;
	public FlightBoon(){
		super(new FlightEvent(defaultDuration),defaultManaCost);
	}
	
	public FlightBoon(int manacost, int duration){
		super(new FlightEvent(duration),manacost);
	}

}
