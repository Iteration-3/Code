package model.slots;

import model.item.Shield;
import model.item.TwoHandedWeapon;
import model.item.Weapon;

public class TwoHandedWeaponSlot extends EquipmentSlot<TwoHandedWeapon> {
	private WeaponSlot weaponSlot;
	private EquipmentSlot<Shield> shieldSlot;

	// TODO change if necessary the WeaponSLot type
	public TwoHandedWeaponSlot(WeaponSlot weaponSlot,
			EquipmentSlot<Shield> shieldSlot) {
		this.weaponSlot = weaponSlot;
		this.shieldSlot = shieldSlot;
		this.weaponSlot.setParentSlot(this);
		this.shieldSlot.setParentSlot(this);
	}

	public boolean equip(TwoHandedWeapon weapon) {
		if (this.childrenHaveItem()) {
			return false;
		} else {
			return this.equip(weapon);
		}
	}

	public boolean equip(Shield shield) {
		if (this.has()) {
			return false;
		} else {
			return this.shieldSlot.equip(shield);
		}
	}

	public boolean equip(Weapon weapon) {
		if (this.has()) {
			return false;
		} else {
			return this.weaponSlot.equip(weapon);
		}
	}

	private boolean childrenHaveItem() {
		return this.weaponSlot.has() || this.shieldSlot.has();
	}
}
