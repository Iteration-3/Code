package model.event;

import utilities.structuredmap.StructuredMap;
import model.entity.Entity;
import model.statistics.Statistics;

public class StatisticModifierEvent extends Event {
	private Statistics modifier;

	public StatisticModifierEvent(Statistics modifier, Entity target, double duration) {
		super(target, duration);
		this.modifier = modifier;
	}
	
	public StatisticModifierEvent(Statistics modifier, double duration) {
		super(duration);
		this.modifier = modifier;
	}
	
	public StatisticModifierEvent(StructuredMap map) {
		super(map);
		this.modifier = new Statistics(map.getStructuredMap("modifier"));
	}

	@Override
	public void perform() {
		if (hasTarget()) {
			getTarget().modifyStats(modifier);
		}
	}

	@Override
	public Event clone() {
		StatisticModifierEvent clone = new StatisticModifierEvent(modifier, getTarget(), getDuration());
		return clone;
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("modifier", modifier.getStructuredMap());
		return map;
		
	}

	@Override
	protected String getType() {
		return "statisticsModifier";
	}

}
