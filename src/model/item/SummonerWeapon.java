package model.item;

import model.slots.SummonerWeaponSlot;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class SummonerWeapon extends Weapon {
	
	public SummonerWeapon(ItemView itemView) {
		super(itemView);
	}

	public SummonerWeapon(ItemView itemView, Statistics statistics) {
		super(itemView, statistics);
	}

	public SummonerWeapon(StructuredMap structuredMap) {
		super(structuredMap);
	}

	@Override
	public boolean equip(SummonerWeaponSlot slot){
		return slot.equipWeapon(this);
	}
	
	@Override
	public boolean canEquip(SummonerWeaponSlot slot){
		return true;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		return "summoner";
	}
}
