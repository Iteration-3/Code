package model.item;

import model.slots.SmasherWeaponSlot;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class SmasherWeapon extends Weapon {
	
	public SmasherWeapon(ItemView itemView, String name) {
		super(itemView, name);
	}

	public SmasherWeapon(ItemView itemView, Statistics statistics, String name) {
		super(itemView, statistics, name);
	}

	public SmasherWeapon(StructuredMap structuredMap) {
		super(structuredMap);
	}

	@Override
	public boolean equip(SmasherWeaponSlot slot){
		return slot.equipWeapon(this);
	}
	
	@Override
	public boolean canEquip(SmasherWeaponSlot slot){
		return true;
	}

	@Override
	public String getType() {
		return "smasher";
	}

}
