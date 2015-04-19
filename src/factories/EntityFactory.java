package factories;

import model.entity.Avatar;
import model.entity.Mount;
import model.entity.NPC;
import model.entity.Pet;
import model.entity.Smasher;
import model.entity.Sneak;
import model.entity.Summoner;
import utilities.structuredmap.StructuredMap;

public class EntityFactory {

	public static Avatar createAvatar(StructuredMap map) {
		switch (map.getString("type")) {
		case "summoner":
			return new Summoner(map);
		case "smasher":
			return new Smasher(map);
		case "sneak":
			return new Sneak(map);
		default:
			return null;
		}
	}
	
	public static NPC createNPC(StructuredMap map) {
		switch(map.getString("type")) {
		case "npc" :
			return new NPC(map);
		case "pet" :
			return new Pet(map);
		case "mount" :
			return new Mount(map);
		default :
			return null;
		}
	}

}
