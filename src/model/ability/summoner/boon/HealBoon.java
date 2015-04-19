package model.ability.summoner.boon;

import model.ability.SelfAbility;
import model.event.HealthModifierEvent;
import utilities.structuredmap.StructuredMap;

public final class HealBoon extends SelfAbility {
	
	public HealBoon() {
		super(new HealthModifierEvent(5, 5), 10);
	}
	
	public HealBoon(int manaCost) {
		this();
		this.setManaCost(manaCost);
	}
	
	public HealBoon(StructuredMap map) {
		super(map);
	}

	@Override
	protected String getType() {
		return "healBoon";
	}

}
