package model.slots;

import model.item.SneakWeapon;
import model.item.Weapon;

public class SneakWeaponSlot extends WeaponSlot<SneakWeapon> {
	
	public SneakWeaponSlot(){}

	public boolean equip(Weapon weapon) {
		return weapon.equip(this);
	}

	public boolean canEquip(Weapon weapon) {
		return weapon.canEquip(this);
	}

	@Override
	public String getType() {
		return "sneak";
	}

}
