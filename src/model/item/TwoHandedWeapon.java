package model.item;

import model.slots.ItemManager;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class TwoHandedWeapon extends Weapon {
	
	public TwoHandedWeapon(ItemView itemView) {
		super(itemView);
	}

	public TwoHandedWeapon(ItemView itemView, Statistics statistics) {
		super(itemView, statistics);
	}

	public TwoHandedWeapon(StructuredMap structuredMap) {
		super(structuredMap);
	}

	@Override
	public String getInfo() {
		return null;
	}

	public void unequip(ItemManager itemManager) {
		itemManager.unequipTHW();
	}

	@Override
	public String getType() {
		return "THW";
	}

}
