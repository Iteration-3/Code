package model.slots;

import model.item.SneekWeapon;
import model.item.Weapon;

public class SneekWeaponSlot extends WeaponSlot<SneekWeapon> {
	
	public SneekWeaponSlot(){}

	public boolean equip(Weapon weapon) {
		return weapon.equip(this);
	}

}
