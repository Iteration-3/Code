package model.item;

import model.slots.ItemManager;
import model.slots.SmasherWeaponSlot;
import model.slots.SneakWeaponSlot;
import model.slots.SummonerWeaponSlot;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public abstract class Weapon extends EquipableItem{
	
	public Weapon(ItemView itemView, String name) {
		super(itemView, name);
	}

	public Weapon(ItemView itemView, Statistics statistics, String name) {
		super(itemView, statistics, name);
	}
	
	public Weapon(StructuredMap map) {
		super(map);
	}

	@Override
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
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("type", getType());
		return map;
	}
	
	@Override
	public abstract String getType();
}
