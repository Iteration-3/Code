package model.item;

import model.statistics.Statistics;

public class NPCWeapon extends Weapon {
	
	//needed to create a NPC specific Weapon for the EquipmentManager
	//because the NPC needs a EquipmentManager but is not a Sneak, Summoner, or Smasher

	public NPCWeapon(Statistics stats) {
		super(stats);
	}

	@Override
	public String getInfo() {
		return "This is the NPC Weapon";
	}

}
