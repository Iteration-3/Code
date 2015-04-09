package model.item;

import model.entity.Entity;
import model.slots.EquipmentManager;

public abstract class EquipableItem extends TakeableItem {

	public abstract boolean equip(EquipmentManager equipment);
	
	public void use(Entity entity) {
		entity.equipItem(this);
	}
}
