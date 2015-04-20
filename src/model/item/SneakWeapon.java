package model.item;

import model.slots.SneakWeaponSlot;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class SneakWeapon extends Weapon {
	
	public SneakWeapon(ItemView itemView, String name) {
		super(itemView, name);
	}

	public SneakWeapon(ItemView itemView, Statistics statistics, String name) {
		super(itemView, statistics, name);
	}

	public SneakWeapon(StructuredMap structuredMap) {
		super(structuredMap);
	}

	@Override
	public boolean equip(SneakWeaponSlot slot){
		return slot.equipWeapon(this);
	}
	
	@Override
	public boolean canEquip(SneakWeaponSlot slot){
		return true;
	}

	@Override
	public String getType() {
		return "sneak";
	}

}
