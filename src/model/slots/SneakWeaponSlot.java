package model.slots;

import model.item.SneekWeapon;
import model.item.Weapon;

public class SneakWeaponSlot extends WeaponSlot<SneekWeapon> {
	
	public SneakWeaponSlot(){}

	public boolean equip(Weapon weapon) {
		return weapon.equip(this);
	}

	public boolean canEquip(Weapon weapon) {
		return weapon.canEquip(this);
	}

}
