package model.event;

import model.entity.Entity;
import statistics.EntityStatistics;

public class StatisticModifierEvent extends UnsourcedEvent {
	private EntityStatistics modifier;

	public StatisticModifierEvent(EntityStatistics modifier, Entity target, double duration) {
		super(target, duration);
		this.modifier = modifier;
	}
	
	public StatisticModifierEvent(EntityStatistics modifier, double duration) {
		super(duration);
		this.modifier = modifier;
	}

	@Override
	public void onExpired() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hasExpired() {
		// TODO Auto-generated method stub

	}

	@Override
	public void perform() {
		// TODO Auto-generated method stub

	}

}
