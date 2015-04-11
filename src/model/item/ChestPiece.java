package model.item;

import model.slots.EquipmentManager;
import model.slots.ItemManager;
import model.statistics.Statistics;

public class ChestPiece extends EquipableItem {

	public ChestPiece(Statistics stats) {
		super(stats);
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
