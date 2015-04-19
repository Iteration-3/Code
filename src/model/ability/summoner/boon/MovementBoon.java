package model.ability.summoner.boon;

import model.ability.SelfAbility;
import model.event.MovementModifierEvent;
import utilities.structuredmap.StructuredMap;

public class MovementBoon extends SelfAbility {
	
	public MovementBoon() {
		super(new MovementModifierEvent(7, 50), 15);
	}
	
	public MovementBoon(int manaCost) {
		this();
		this.setManaCost(manaCost);
	}
	
	public MovementBoon(StructuredMap map) {
		super(map);
	}

	@Override
	protected String getType() {
		return "movementBoon";
	}

}
