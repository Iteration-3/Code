package model.slots;

import model.item.Weapon;
import utilities.structuredmap.StructuredMap;

public abstract class WeaponSlot <K extends Weapon> extends EquipmentSlot<K> {

	public boolean equipWeapon(K item){
		return super.equip(item);
	}
	
	public abstract boolean equip(Weapon weapon);
	
	public abstract boolean canEquip(Weapon weapon);
	
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("type", getType());
		return map;
	}
	
	public abstract String getType();
}