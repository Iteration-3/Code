package model.item;

import model.slots.SneekWeaponSlot;

public class SneekWeapon extends Weapon {

	public boolean equip(SneekWeaponSlot slot){
		return slot.equip(this);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
