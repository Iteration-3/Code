package model.event;

import model.entity.Entity;
import utilities.structuredmap.StructuredMap;

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
	
	public HealthModifierEvent(StructuredMap map) {
		super(map);
		this.health = map.getInteger("health");
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
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("health", this.health);
		return map;
	}

	@Override
	protected String getType() {
		return "healthModifier";
	}

}
