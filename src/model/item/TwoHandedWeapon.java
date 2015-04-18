package model.item;

import model.slots.ItemManager;
import model.statistics.Statistics;
import view.item.ItemView;

public class TwoHandedWeapon extends Weapon {
	
	public TwoHandedWeapon(ItemView itemView) {
		super(itemView);
	}

	public TwoHandedWeapon(ItemView itemView, Statistics statistics) {
		super(itemView, statistics);
	}

	@Override
	public String getInfo() {
		return null;
	}

	public void unequip(ItemManager itemManager) {
		itemManager.unequipTHW();
	}

}
