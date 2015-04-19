package model.slots;

import model.item.EquipableItem;

//TODO structure the THW and all others  so that it is not a EquipableItem

public class DoubleEquipmentSlot  <K extends EquipableItem, F extends EquipableItem,S extends EquipableItem>
								extends EquipmentSlot<K> {


	private EquipmentSlot<F> weaponSlot;
	private EquipmentSlot<S> shieldSlot;

	// TODO change if necessary the WeaponSLot type
	public DoubleEquipmentSlot(EquipmentSlot<F> weaponSlot,
			EquipmentSlot<S> shieldSlot) {
		super();
		this.weaponSlot = weaponSlot;
		this.shieldSlot = shieldSlot;
		this.weaponSlot.setParentSlot(this);
		this.shieldSlot.setParentSlot(this);
	}

	public boolean equip(K weapon) {
		if (this.childrenHaveItem()) {
			return false;
		} else {
			return super.equip(weapon);
		}
	}

	public boolean equipSecondSlot(S shield) {
		if (this.has()) {
			return false;
		} else {
			return this.shieldSlot.equip(shield);
		}
	}

	public boolean equipFirstSlot(F weapon) {
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
