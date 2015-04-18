package model.item;

import model.slots.SummonerWeaponSlot;
import model.statistics.Statistics;
import view.item.ItemView;

public class SummonerWeapon extends Weapon {
	
	public SummonerWeapon(ItemView itemView) {
		super(itemView);
	}

	public SummonerWeapon(ItemView itemView, Statistics statistics) {
		super(itemView, statistics);
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
