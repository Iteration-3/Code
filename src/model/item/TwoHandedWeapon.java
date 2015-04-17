package model.item;

import model.slots.ItemManager;
import model.statistics.Statistics;
import view.item.ItemView;

public class TwoHandedWeapon extends Weapon {

	public TwoHandedWeapon(ItemView itemView, Statistics stats) {
		super(itemView, stats);
	}

	@Override
	public String getInfo() {
		return null;
	}

	public void unequip(ItemManager im) {
		im.unequipTHW();
	}

}
