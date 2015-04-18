package model.item;

import model.slots.SneakWeaponSlot;
import model.statistics.Statistics;
import view.item.ItemView;

public class SneakWeapon extends Weapon {
	
	public SneakWeapon(ItemView itemView) {
		super(itemView);
	}

	public SneakWeapon(ItemView itemView, Statistics statistics) {
		super(itemView, statistics);
	}

	public boolean equip(SneakWeaponSlot slot){
		return slot.equipWeapon(this);
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
