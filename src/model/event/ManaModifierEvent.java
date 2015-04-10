package model.event;

import model.entity.Entity;

public class ManaModifierEvent extends Event {
	private int mana;

	public ManaModifierEvent(double duration, int mana) {
		super(duration);
		this.mana = mana;
	}

	public ManaModifierEvent(int mana, Entity target, double duration) {
		super(target, duration);
		this.mana = mana;
	}

	@Override
	public void perform() {
		if (hasTarget()) {
			getTarget().addMana(mana);
		}
	}

	@Override
	public Event clone() {
		ManaModifierEvent clone = new ManaModifierEvent(mana, getTarget(), getDuration());
		return clone;
	}

}
