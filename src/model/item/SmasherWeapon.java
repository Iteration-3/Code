package model.item;

import model.slots.SmasherWeaponSlot;

public class SmasherWeapon extends Weapon {

	public boolean equip(SmasherWeaponSlot slot){
		return slot.equipWeapon(this);
	}

}
