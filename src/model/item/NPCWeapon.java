package model.item;

import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class NPCWeapon extends Weapon {
	
	//needed to create a NPC specific Weapon for the EquipmentManager
	//because the NPC needs a EquipmentManager but is not a Sneak, Summoner, or Smasher
	
	public NPCWeapon(ItemView itemView) {
		super(itemView);
	}

	public NPCWeapon(ItemView itemView, Statistics statistics) {
		super(itemView, statistics);
	}

	public NPCWeapon(StructuredMap structuredMap) {
		super(structuredMap);
	}

	@Override
	public String getInfo() {
		return "This is the NPC Weapon";
	}

	@Override
	public String getType() {
		return "npc";
	}

}
