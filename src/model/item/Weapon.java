package model.item;

import model.slots.ItemManager;
import model.slots.SmasherWeaponSlot;
import model.slots.SneakWeaponSlot;
import model.slots.SummonerWeaponSlot;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public abstract class Weapon extends EquipableItem{
	
	public Weapon(ItemView itemView) {
		super(itemView);
	}

	public Weapon(ItemView itemView, Statistics statistics) {
		super(itemView, statistics);
	}
	
	public Weapon(StructuredMap map) {
		super(map);
	}

	public boolean equip(ItemManager itemManager){
		return itemManager.equipToSlot(this);
	}

	public boolean equip(SneakWeaponSlot slot){
		return false;
	}
	public boolean equip(SummonerWeaponSlot slot){
		return false;
	}
	public boolean equip(SmasherWeaponSlot slot){
		return false;
	}
	public boolean canEquip(SneakWeaponSlot slot){
		return false;
	}
	public boolean canEquip(SummonerWeaponSlot slot){
		return false;
	}
	public boolean canEquip(SmasherWeaponSlot slot){
		return false;
	}
	
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("type", getType());
		return map;
	}
	
	public abstract String getType();
}
