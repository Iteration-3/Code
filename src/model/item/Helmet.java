package model.item;

import model.slots.EquipmentManager;

public class Helmet extends Equipable{

	boolean equip(EquipmentManager equipment) {
		return equipment.equip(this);
	}
}
