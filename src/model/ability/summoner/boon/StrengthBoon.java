package model.ability.summoner.boon;

import model.ability.SelfAbility;
import model.event.StatisticModifierEvent;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;

public class StrengthBoon extends SelfAbility {
	
	public StrengthBoon() {
		super(new StatisticModifierEvent(new Statistics(25, 0, 0, 0), 10), 15);
	}
	
	public StrengthBoon(int manaCost) {
		this();
		this.setManaCost(manaCost);
	}
	
	public StrengthBoon(StructuredMap map) {
		super(map);
	}

	@Override
	protected String getType() {
		return "strengthBoon";
	}

}
