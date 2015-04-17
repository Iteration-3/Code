package model.item;

import model.statistics.Statistics;
import view.item.ItemView;

public class NPCWeapon extends Weapon {
	
	//needed to create a NPC specific Weapon for the EquipmentManager
	//because the NPC needs a EquipmentManager but is not a Sneak, Summoner, or Smasher

	public NPCWeapon(ItemView itemView, Statistics stats) {
		super(itemView, stats);
	}

	@Override
	public String getInfo() {
		return "This is the NPC Weapon";
	}

}
