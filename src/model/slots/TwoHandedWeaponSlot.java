package model.slots;

import model.item.EquipableItem;
import model.item.Shield;
import model.item.TakeableItem;
import model.item.TwoHandedWeapon;
import model.item.Weapon;
import model.statistics.Statistics;

public class TwoHandedWeaponSlot {
	private WeaponSlot weaponSlot;
	private EquipmentSlot<Shield> shieldSlot;
	private EquipmentSlot<TwoHandedWeapon> slot;
	
	//TODO change if necessary  the WeaponSLot type
	public TwoHandedWeaponSlot(WeaponSlot weaponSlot,EquipmentSlot<Shield> shieldSlot){
		this.weaponSlot = weaponSlot;
		this.shieldSlot = shieldSlot;
		this.weaponSlot.setParentSlot(this);
		this.shieldSlot.setParentSlot(this);
	}
	
	public boolean has(){
		return this.slot.has();
	}
	
	public TwoHandedWeapon get(){
		return this.slot.get();
	}
	
	public TwoHandedWeapon unequip(){
		return this.slot.unequip();
	}
	
	public void merge(Statistics stats){
		this.slot.merge(stats);
	}
	
	public boolean has(EquipableItem item){
		return this.slot.has(item);
	}
	
	public boolean equip(TwoHandedWeapon weapon){
		if (this.childrenHaveItem()){
			return false;
		}
		else{
			return this.slot.equip(weapon);
		}
	}
	
	public boolean equip(Shield shield){
		if (this.has()){
			return false;
		}
		else{
			return this.shieldSlot.equip(shield);
		}
	}
	
	public boolean equip(Weapon weapon){
		if (this.has()){
			return false;
		}
		else{
			return this.weaponSlot.equip(weapon);
		}
	}

	private boolean childrenHaveItem(){
		return this.weaponSlot.has() || this.shieldSlot.has();
	}
}
