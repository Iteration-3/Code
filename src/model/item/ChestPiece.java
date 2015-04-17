package model.item;

import model.slots.EquipmentManager;
import model.slots.ItemManager;
import model.statistics.Statistics;
import view.item.ItemView;

public class ChestPiece extends EquipableItem {

	public ChestPiece(ItemView itemView, Statistics stats) {
		super(itemView, stats);
	}

	public boolean equip(EquipmentManager equipment) {
		return equipment.equip(this);
	}
	
	public void unequip(ItemManager im) {
		im.unequipChestPiece();
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	} 

}
