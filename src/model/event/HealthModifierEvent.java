package model.event;

import model.entity.Entity;

public class HealthModifierEvent extends Event {
	int health;

	public HealthModifierEvent(double duration, int health) {
		super(duration);
		this.health = health;
	}

	public HealthModifierEvent(Entity target, double duration, int health) {
		super(target, duration);
		this.health = health;
	}

	@Override
	public boolean hasExpired() {
		return false;
	}

	@Override
	public void perform() {
		if (hasTarget()) {
			getTarget().addHealth(health);
		}
	}

}
