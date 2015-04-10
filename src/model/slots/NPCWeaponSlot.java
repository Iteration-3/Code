package model.slots;

import model.item.NPCWeapon;
import model.item.Weapon;

public class NPCWeaponSlot extends WeaponSlot<NPCWeapon> {

	@Override
	public boolean equip(Weapon weapon) {
		return false;
	}

	@Override
	public boolean canEquip(Weapon weapon) {
		return false;
	}

}
