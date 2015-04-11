package model.slots;

import model.item.Weapon;

public abstract class WeaponSlot <K extends Weapon> extends EquipmentSlot<K> {

	public boolean equipWeapon(K item){
		return super.equip(item);
	}
	
	public abstract boolean equip(Weapon weapon);
	
	public abstract boolean canEquip(Weapon weapon);
}