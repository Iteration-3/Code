package model.item;

import model.slots.EquipmentManager;

public class Shield extends Equipable{

	public boolean equip(EquipmentManager equipment) {
		return equipment.equip(this);
	}

}
