package model.item;

import model.slots.SummonerWeaponSlot;

public class SummonerWeapon extends Weapon {

	public boolean equip(SummonerWeaponSlot slot){
		return slot.equip(this);
	}
	
	public boolean canEquip(SummonerWeaponSlot slot){
		return true;
	}

	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}
}