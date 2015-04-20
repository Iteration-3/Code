package factories;

import model.area.TileCoordinate;
import model.entity.Avatar;
import model.entity.EntityManager;
import model.entity.Mount;
import model.entity.NPC;
import model.entity.Smasher;
import model.entity.Sneak;
import model.entity.Summoner;
import model.entity.behavior.npc.BarterBehavior;
import model.entity.behavior.npc.Behaviorable;
import model.entity.behavior.npc.Coward;
import model.entity.behavior.npc.PetBehavior;
import model.entity.behavior.npc.TrooperBehavior;
import utilities.Direction;
import utilities.structuredmap.StructuredMap;
import view.entity.EntitySpriteFactory;
import view.entity.EntityView;
import view.layout.GameplayLayout;
import view.layout.Layout;

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
		// I DONT KNOW
		switch (map.getString("type")) {
		case "barter":
			return createNPC(map, new BarterBehavior());
		case "trooper":
			return createNPC(map, new TrooperBehavior(7));
		case "pet":
			return createNPC(map, new PetBehavior());
		case "heavyTrooper":
			return createNPC(map, new TrooperBehavior(7));
		case "mount":
			return new Mount(map);
		default:
			return null;
		}
	}

	private static NPC createNPC(StructuredMap map, Behaviorable behavior) {
		return new NPC(map, behavior);
	}

	public static NPC createBarter(String name, EntityView view,
			TileCoordinate location) {
		NPC entity = new NPC(name, "barter", view, location,
				new BarterBehavior());
		System.out.println(entity + " this is the barter ");
		return entity;
	}

	public static NPC createLightTrooper(String name, EntityView view,
			TileCoordinate location) {
		NPC entity = new NPC(name, "trooper", view, location,
				new TrooperBehavior(7));
		return entity;
	}

	public static NPC createPet(String name, EntityView view,
			TileCoordinate location) {
		NPC entity = new NPC(name, "pet", view, location, new PetBehavior());
		return entity;
	}

	public static NPC createHeavyTrooper(String name, TileCoordinate location,
			GameplayLayout layout) {
		EntityView view = new EntityView(
				EntitySpriteFactory.getDarkTrooperSpriteHolder());
		NPC entity = new NPC(name, "heavyTrooper", view, location,
				new TrooperBehavior(12));
		setEntity(entity,location,view,layout);
		return entity;
	}
	
	public static void setEntity(NPC entity, TileCoordinate location,EntityView view,GameplayLayout layout){
		entity.setStats(StatsFactory.getHeavyTrooperStats());
		view.registerWithGameMapView(layout.getGameEntityView(),
				TileCoordinate.convertToRealCoordinate(location), Direction.UP);
		EntityManager.getSingleton().addNonPartyNpc(entity);
	}

	public static Mount createMount(String name, EntityView view,
			TileCoordinate location) {
		// LISTEN if the Mount does not work, let Jacob know
		Mount entity = new Mount(name, view, location);
		return entity;
	}

	public static NPC createCowardTrooper(String name, TileCoordinate location,
			GameplayLayout layout) {
		EntityView view = new EntityView(
				EntitySpriteFactory.getTrooperSpriteHolder());
		NPC entity = new NPC(name, "heavyTrooper", view, location,
				new TrooperBehavior(new Coward(true, EntityManager
						.getSingleton().getAvatar()), 7));
		entity.setStats(StatsFactory.getTrooperStats());
		setEntity(entity,location,view,layout);
		return entity;
	}
}
