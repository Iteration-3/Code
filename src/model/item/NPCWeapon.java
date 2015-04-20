package model.item;

import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class NPCWeapon extends Weapon {
	
	//needed to create a NPC specific Weapon for the EquipmentManager
	//because the NPC needs a EquipmentManager but is not a Sneak, Summoner, or Smasher
	
	public NPCWeapon(ItemView itemView, String name) {
		super(itemView, name);
	}

	public NPCWeapon(ItemView itemView, Statistics statistics, String name) {
		super(itemView, statistics, name);
	}

	public NPCWeapon(StructuredMap structuredMap) {
		super(structuredMap);
	}

	@Override
	public String getType() {
		return "npc";
	}

}
