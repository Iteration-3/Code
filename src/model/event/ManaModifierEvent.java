package model.event;

import utilities.structuredmap.StructuredMap;
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
	
	public ManaModifierEvent(StructuredMap map) {
		super(map);
		this.mana = map.getInteger("mana");
	}

	@Override
	public void perform() {
		if (hasTarget()) {
			getTarget().addCurrentMana(mana);
		}
	}

	@Override
	public Event clone() {
		ManaModifierEvent clone = new ManaModifierEvent(mana, getTarget(),
				getDuration());
		return clone;
	}

	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("mana", mana);
		return map;
	}

	@Override
	protected String getType() {
		return "manaModifier";
	}

}
