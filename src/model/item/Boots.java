package model.item;

import model.slots.ItemManager;
import model.statistics.Statistics;
import view.item.ItemView;

public class Boots extends EquipableItem {
	
	public Boots(ItemView itemView) {
		super(itemView);
	}

	public Boots(ItemView itemView, Statistics statistics) {
		super(itemView, statistics);
	}

	public boolean equip(ItemManager itemManager) {
		return itemManager.equipToSlot(this);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
