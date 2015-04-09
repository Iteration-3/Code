package model.slots;

import model.item.SummonerWeapon;
import model.item.Weapon;

public class SummonerWeaponSlot extends WeaponSlot<SummonerWeapon>{
	
	public SummonerWeaponSlot(){}

	public boolean equip(Weapon weapon) {
		return weapon.equip(this);
	}

}
