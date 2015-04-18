package model.ability;

import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import model.entity.Avatar;

public abstract class Ability implements Saveable {
	private int manaCost = 0;
	
	public Ability() {}
	
	public Ability(int manaCost) {
		setManaCost(manaCost);
	}
	
	public Ability(StructuredMap map) {
		this.manaCost = map.getInteger("manaCost");
	}

	public abstract void perform(Avatar avatar);
	
	public final boolean hasMana(Avatar avatar) {
		return avatar.getBaseStats().getCurrentMana() >= this.getManaCost();
	}
	
	public final void removeMana(Avatar avatar) {
		avatar.getBaseStats().addCurrentMana(-1 * manaCost);
	}

	public int getManaCost() {
		return manaCost;
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
	
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("manaCost", manaCost);
		map.put("type", getType());
		return map;
	}
	
	protected abstract String getType();

}
