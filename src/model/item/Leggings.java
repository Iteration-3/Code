package model.item;

import model.slots.EquipmentManager;

public class Leggings extends Equipable{

	public boolean equip(EquipmentManager equipment) {
		return equipment.equip(this);
	}

}
