package model.slots;

import model.item.EquipableItem;
import model.item.Weapon;

public abstract class WeaponSlot <K extends Weapon> {
	private EquipmentSlot<K> slot;
	
	public WeaponSlot(){}
	
	public boolean has(){
		return this.slot.has();
	}
	
	public K get(){
		return this.slot.get();
	}
	
	public boolean equipWeapon(K item){
		return this.slot.equip(item);
	}
	
	public K unequip(){
		return this.slot.unequip();
	}
	
	public boolean has(EquipableItem item){
		return this.slot.has(item);
	}
	
	public abstract boolean equip(Weapon weapon);
}