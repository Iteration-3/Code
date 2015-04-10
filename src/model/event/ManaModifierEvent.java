package model.event;

import model.entity.Entity;

public class ManaModifierEvent extends Event {
	private int mana;

	public ManaModifierEvent(double duration, int mana) {
		super(duration);
		this.mana = mana;
	}

	public ManaModifierEvent(Entity target, double duration, int mana) {
		super(target, duration);
		this.mana = mana;
	}

	@Override
	public boolean hasExpired() {
		return false;
	}

	@Override
	public void perform() {
		if (hasTarget()) {
			getTarget().addMana(mana);
		}
	}

	@Override
	public Event clone() {
		ManaModifierEvent clone = new ManaModifierEvent(getTarget(), getDuration(), mana);
		return clone;
	}

}
