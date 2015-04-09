package model.item;

import model.slots.EquipmentManager;
import model.slots.SmasherWeaponSlot;
import model.slots.SneekWeaponSlot;
import model.slots.SummonerWeaponSlot;

public abstract class Weapon extends EquipableItem{

	public boolean equip(EquipmentManager equipment){
		return equipment.equip(this);
	}
	
	public boolean equip(SneekWeaponSlot slot){
		return false;
	}
	public boolean equip(SummonerWeaponSlot slot){
		return false;
	}
	public boolean equip(SmasherWeaponSlot slot){
		return false;
	}
}
