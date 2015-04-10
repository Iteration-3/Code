package model.event;

import model.entity.Entity;
import statistics.Statistics;

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

}
