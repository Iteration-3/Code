package model.item;

import model.slots.SummonerWeaponSlot;
import model.statistics.Statistics;

public class SummonerWeapon extends Weapon {

	public SummonerWeapon(Statistics stats) {
		super(stats);
	}

	public boolean equip(SummonerWeaponSlot slot){
		return slot.equipWeapon(this);
	}
	
	public boolean canEquip(SummonerWeaponSlot slot){
		return true;
	}

	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}
}
