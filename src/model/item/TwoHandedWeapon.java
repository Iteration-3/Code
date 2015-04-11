package model.item;

import model.slots.ItemManager;
import model.statistics.Statistics;

public class TwoHandedWeapon extends Weapon {

	public TwoHandedWeapon(Statistics stats) {
		super(stats);
	}

	@Override
	public String getInfo() {
		return null;
	}

	public void unequip(ItemManager im) {
		im.unequipTHW();
	}

}
