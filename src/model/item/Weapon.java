package model.item;

import model.slots.EquipmentManager;
import model.slots.ItemManager;
import model.slots.SmasherWeaponSlot;
import model.slots.SneakWeaponSlot;
import model.slots.SummonerWeaponSlot;
import model.statistics.Statistics;
import view.item.ItemView;

public abstract class Weapon extends EquipableItem{

	public Weapon(ItemView itemView, Statistics stats) {
		super(itemView, stats);
	}

	public boolean equip(EquipmentManager equipment){
		return equipment.equip(this);
	}
	
	public void unequip(ItemManager im){
		im.unequipWeapon();
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
