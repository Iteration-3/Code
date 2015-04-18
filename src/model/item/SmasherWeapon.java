package model.item;

import model.slots.SmasherWeaponSlot;
import model.statistics.Statistics;
import view.item.ItemView;

public class SmasherWeapon extends Weapon {
	
	public SmasherWeapon(ItemView itemView) {
		super(itemView);
	}

	public SmasherWeapon(ItemView itemView, Statistics statistics) {
		super(itemView, statistics);
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
