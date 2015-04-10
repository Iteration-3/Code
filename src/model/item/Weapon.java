package model.item;

import statistics.Statistics;
import model.slots.EquipmentManager;
import model.slots.SmasherWeaponSlot;
import model.slots.SneakWeaponSlot;
import model.slots.SummonerWeaponSlot;

public abstract class Weapon extends EquipableItem{

	public Weapon(Statistics stats) {
		super(stats);
	}

	public boolean equip(EquipmentManager equipment){
		return equipment.equip(this);
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
}
