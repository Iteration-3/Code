package model.event;

import model.entity.Entity;
import utilities.structuredmap.StructuredMap;

public class HealthModifierEvent extends SourcedEvent {
	private int health;
	private Entity source;

	public HealthModifierEvent(Entity source, Entity target, double duration,
			int health) {
		super(source, target, duration);
		this.health = health;
	}

	// public HealthModifierEvent(int health, Entity target,Entity source,
	// double duration) {
	// super(target, duration);
	// this.health = health;
	// this.source = source;
	// }
	//
	// public HealthModifierEvent(int health, Entity target, double duration) {
	// super(target, duration);
	// this.health = health;
	// }

	public HealthModifierEvent(StructuredMap map) {
		super(map);
		this.health = map.getInteger("health");
	}

	@Override
	public void perform() {
		if (hasTarget()) {
			if (this.healthIsDamage()) {
				if (hasSource()){
					getTarget().onDamage(source);
				}
			}
			getTarget().addHealth(health);
		}
	}

	private boolean hasSource() {
		return this.source != null;
	}

	private boolean healthIsDamage() {
		return this.health < 0;
	}

	public void scaleHealth(double scaler) {
		this.health = (int) Math.round(health * scaler);
	}

	@Override
	public HealthModifierEvent clone() {
		HealthModifierEvent clone = new HealthModifierEvent(getSource(),
				getTarget(), getDuration(), health);
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
