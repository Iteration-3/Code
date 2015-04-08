package model.item;

import model.slots.EquipmentManager;

public abstract class EquipableItem extends TakeableItem {

	public abstract boolean equip(EquipmentManager equipment);
}
