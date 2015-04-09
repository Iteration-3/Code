package model.slots;

import model.item.SmasherWeapon;
import model.item.Weapon;

public class SmasherWeaponSlot extends WeaponSlot<SmasherWeapon>{

	public boolean equip(Weapon weapon) {
		return weapon.equip(this);
	}
	
	

}
