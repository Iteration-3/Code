package model.ability;

import model.entity.Avatar;

public abstract class Ability{
	private int manaCost = 0;
	
	public Ability() {}
	
	public Ability(int manaCost) {
		setManaCost(manaCost);
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
	
}
