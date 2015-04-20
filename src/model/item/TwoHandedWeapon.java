package model.item;

import model.slots.ItemManager;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class TwoHandedWeapon extends EquipableItem {
	
	public TwoHandedWeapon(ItemView itemView, String name) {
		super(itemView, name);
	}

	public TwoHandedWeapon(ItemView itemView, Statistics statistics, String name) {
		super(itemView, statistics, name);
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

	@Override
	public boolean equip(ItemManager itemManager) {
		return itemManager.equipToSlot(this);
	}

}
