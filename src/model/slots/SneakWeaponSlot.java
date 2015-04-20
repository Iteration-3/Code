package model.slots;

import model.item.SneakWeapon;
import model.item.Weapon;

public class SneakWeaponSlot extends WeaponSlot<SneakWeapon> {
	
	public SneakWeaponSlot(){}

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
		return "sneak";
	}

}
