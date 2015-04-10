package model.event;

import model.entity.Entity;

public class MovementModifierEvent extends Event {
	private int movement;

	public MovementModifierEvent(double duration, int movement) {
		super(duration);
		this.movement = movement;
	}

	public MovementModifierEvent(Entity target, double duration, int movement) {
		super(target, duration);
		this.movement = movement;
	}

	@Override
	public boolean hasExpired() {
		return false;
	}

	@Override
	public void perform() {
		if (hasTarget()) {
			getTarget().addMovement(movement);
		}
	}

	@Override
	public Event clone() {
		MovementModifierEvent clone = new MovementModifierEvent(getTarget(), getDuration(), movement);
		return clone;
	}

}