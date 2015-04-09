package model.item;

import model.slots.SmasherWeaponSlot;

public class SmasherWeapon extends Weapon {

	public boolean equip(SmasherWeaponSlot slot){
		return slot.equipWeapon(this);
	}
	
	public boolean canEquip(SmasherWeaponSlot slot){
		return true;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
