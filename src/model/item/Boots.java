package model.item;

import model.slots.EquipmentManager;
import model.slots.ItemManager;
import model.statistics.Statistics;
import view.item.ItemView;

public class Boots extends EquipableItem {

	public Boots(ItemView itemView, Statistics stats) {
		super(itemView, stats);
	}

	public boolean equip(EquipmentManager equipment) {
		return equipment.equip(this);
	}

	public void unequip(ItemManager im) {
		im.unequipBoots();
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
