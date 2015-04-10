package model.item;

import model.slots.SmasherWeaponSlot;
import model.statistics.Statistics;

public class SmasherWeapon extends Weapon {

	public SmasherWeapon(Statistics stats) {
		super(stats);
	}

	public boolean equip(SmasherWeaponSlot slot){
		return slot.equipWeapon(this);
	}
	
	public boolean canEquip(SmasherWeaponSlot slot){
		return true;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
