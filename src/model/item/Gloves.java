package model.item;

import model.slots.EquipmentManager;

public class Gloves extends Equipable{

	public boolean equip(EquipmentManager equipment) {
		return equipment.equip(this);
	}

}
