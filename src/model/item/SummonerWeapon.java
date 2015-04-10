package model.item;

import statistics.Statistics;
import model.slots.SummonerWeaponSlot;

public class SummonerWeapon extends Weapon {

	public SummonerWeapon(Statistics stats) {
		super(stats);
	}

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
