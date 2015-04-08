package model.item;

import model.slots.EquipmentManager;

public class ChestPiece extends Equipable{

	boolean equip(EquipmentManager equipment) {
		return equipment.equip(this);
	} 

}
