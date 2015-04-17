package model.ability.summoner.boon;

import model.ability.SelfAbility;
import model.event.HealthModifierEvent;

public final class HealBoon extends SelfAbility {
	
	public HealBoon() {
		super(new HealthModifierEvent(5, 5), 10);
	}
	
	public HealBoon(int manaCost) {
		this();
		this.setManaCost(manaCost);
	}

}
