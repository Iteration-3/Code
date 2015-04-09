package model.item;

import model.entity.Entity;
import model.slots.EquipmentManager;

public class ChestPiece extends EquipableItem {

	public boolean equip(EquipmentManager equipment) {
		return equipment.equip(this);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	} 

}
