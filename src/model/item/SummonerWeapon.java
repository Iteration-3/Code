package model.item;

import model.slots.SummonerWeaponSlot;

public class SummonerWeapon extends Weapon {

	public boolean equip(SummonerWeaponSlot slot){
		return slot.equip(this);
	}
}
