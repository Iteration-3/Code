package model.event;

import model.entity.Entity;
import utilities.structuredmap.StructuredMap;

public class InstantDeathEvent extends Event {

	public InstantDeathEvent(double duration) {
		super(duration);
	}

	public InstantDeathEvent(Entity target, double duration) {
		super(target, duration);
	}
	
	public InstantDeathEvent(StructuredMap map) {
		super(map);
	}

	@Override
	public void perform() {
		if (hasTarget()) {
			getTarget().addLives(-1);
		}
	}

	@Override
	public Event clone() {
		InstantDeathEvent clone = new InstantDeathEvent(getTarget(), getDuration());
		return clone;
	}

	@Override
	protected String getType() {
		return "instantDeath";
	}
	
	

}
