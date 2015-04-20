package factories;

import model.area.TileCoordinate;
import model.entity.Avatar;
import model.entity.Mount;
import model.entity.NPC;
import model.entity.Smasher;
import model.entity.Sneak;
import model.entity.Summoner;
import model.entity.behavior.npc.BarterBehavior;
import model.entity.behavior.npc.PetBehavior;
import model.entity.behavior.npc.TrooperBehavior;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

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
		case "mount" :
			return new Mount(map);
		default :
			return null;
		}
	}
	
	public static NPC createBarter(String name, EntityView view, TileCoordinate location){
		NPC entity = new NPC(name, "barter", view , location ,new BarterBehavior());
		return entity;
	}
	public static NPC createLightTrooper(String name, EntityView view, TileCoordinate location){
		NPC entity = new NPC(name, "trooper", view , location ,new TrooperBehavior());
		return entity;
	}
	public static NPC createPet(String name,EntityView view, TileCoordinate location){
		NPC entity = new NPC(name, "pet", view , location ,new PetBehavior());
		return entity;
	}
	public static NPC createHeavyTrooper(String name,EntityView view, TileCoordinate location){
		NPC entity = new NPC(name, "barter", view , location ,new TrooperBehavior());
		return entity;
	}
	public static Mount createMount(String name,EntityView view, TileCoordinate location){
		//LISTEN if the Mount does not work, let Jacob know
		Mount entity = new Mount(name , view , location);
		return entity;
	}
	

}
