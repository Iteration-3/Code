package model.ability.summoner.boon;

import model.ability.SelfAbility;
import model.event.StatisticModifierEvent;
import model.statistics.Statistics;

public class StrengthBoon extends SelfAbility {
	
	public StrengthBoon() {
		super(new StatisticModifierEvent(new Statistics(25, 0, 0, 0), 10), 15);
	}
	
	public StrengthBoon(int manaCost) {
		this();
		this.setManaCost(manaCost);
	}

	@Override
	protected String getType() {
		return "strengthBoon";
	}

}
