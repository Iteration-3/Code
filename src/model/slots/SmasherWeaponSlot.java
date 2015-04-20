package model.slots;

import model.item.SmasherWeapon;
import model.item.Weapon;

public class SmasherWeaponSlot extends WeaponSlot<SmasherWeapon>{

	@Override
	public boolean equip(Weapon weapon) {
		return weapon.equip(this);
	}
	
	@Override
	public boolean canEquip(Weapon weapon) {
		return weapon.canEquip(this);
	}

	@Override
	public String getType() {
		return "smasher";
	}
}
