package model.item;

import model.slots.SneakWeaponSlot;
import model.statistics.Statistics;

public class SneekWeapon extends Weapon {

	public SneekWeapon(Statistics stats) {
		super(stats);
	}

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
