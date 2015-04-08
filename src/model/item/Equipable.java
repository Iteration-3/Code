package model.item;

import model.slots.EquipmentManager;

public abstract class Equipable extends TakeableItem {

	public abstract boolean equip(EquipmentManager equipment);
}
