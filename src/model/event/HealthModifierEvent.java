package model.event;

import model.entity.Entity;

public class HealthModifierEvent extends Event {
	private int health;

	public HealthModifierEvent(double duration, int health) {
		super(duration);
		this.health = health;
	}

	public HealthModifierEvent(int health, Entity target, double duration) {
		super(target, duration);
		this.health = health;
	}
	
	@Override
	public void perform() {
		if (hasTarget()) {
			getTarget().addHealth(health);
		}
	}
	
	public void scaleHealh(double scaler) {
		this.health = (int) Math.round(health * scaler);
	}

	@Override
	public Event clone() {
		HealthModifierEvent clone = new HealthModifierEvent(health, getTarget(), getDuration());
		return clone;
	}

}
