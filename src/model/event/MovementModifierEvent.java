package model.event;

import utilities.structuredmap.StructuredMap;
import model.entity.Entity;

public class MovementModifierEvent extends Event {
	private int movement;

	public MovementModifierEvent(double duration, int movement) {
		super(duration);
		this.movement = movement;
	}

	public MovementModifierEvent(int movement, Entity target, double duration) {
		super(target, duration);
		this.movement = movement;
	}
	
	public MovementModifierEvent(StructuredMap map) {
		super(map);
		this.movement = map.getInteger("movement");
	}

	@Override
	public void perform() {
		if (hasTarget()) {
			getTarget().addMovement(movement);
		}
	}

	@Override
	public MovementModifierEvent clone() {
		MovementModifierEvent clone = new MovementModifierEvent(movement, getTarget(), getDuration());
		return clone;
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("movement", movement);
		return map;
	}

	@Override
	protected String getType() {
		return "movementModifier";
	}
	
}
