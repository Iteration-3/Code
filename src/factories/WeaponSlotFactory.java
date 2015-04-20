package factories;

import model.slots.NPCWeaponSlot;
import model.slots.SmasherWeaponSlot;
import model.slots.SneakWeaponSlot;
import model.slots.SummonerWeaponSlot;
import model.slots.WeaponSlot;
import utilities.structuredmap.StructuredMap;

public class WeaponSlotFactory {

	public static WeaponSlot<?> createWeaponSlot(StructuredMap structuredMap) {
		
		switch(structuredMap.getString("type")) {
		case "summoner" :
			return new SummonerWeaponSlot();
		case "smasher" :
			return new SmasherWeaponSlot();
		case "sneak" : 
			return new SneakWeaponSlot();
		case "npc" :
			return new NPCWeaponSlot();
		default :
			throw new IllegalArgumentException("Fuck you");
		}
		
	}

}
