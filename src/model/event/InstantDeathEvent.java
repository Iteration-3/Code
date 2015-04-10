package model.event;

import model.entity.Entity;

public class InstantDeathEvent extends Event {

	public InstantDeathEvent(double duration) {
		super(duration);
	}

	public InstantDeathEvent(Entity target, double duration) {
		super(target, duration);
	}

	@Override
	public boolean hasExpired() {
		return true;
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

}
