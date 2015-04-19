package model.slots;

import model.item.SmasherWeapon;
import model.item.Weapon;

public class SmasherWeaponSlot extends WeaponSlot<SmasherWeapon>{

	public boolean equip(Weapon weapon) {
		return weapon.equip(this);
	}
	
	public boolean canEquip(Weapon weapon) {
		return weapon.canEquip(this);
	}

	@Override
	public String getType() {
		return "smasher";
	}
}
