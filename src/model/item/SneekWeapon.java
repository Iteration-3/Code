package model.item;

import model.slots.SneakWeaponSlot;

public class SneekWeapon extends Weapon {

	public boolean equip(SneakWeaponSlot slot){
		return slot.equip(this);
	}
	
	public boolean canEquip(SneakWeaponSlot slot){
		return true;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
