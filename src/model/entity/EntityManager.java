package model.entity;

import java.util.ArrayList;
import java.util.List;

import model.area.RealCoordinate;

public class EntityManager {
	private static ArrayList<NPC> partyNpcs;
	private static ArrayList<NPC> nonPartyNpcs;
	private static Avatar avatar;
	
	
	/**
	 * If we started having something like 10000+ entities, then this should be done eagerly, not lazily
	 * @return
	 */
	private static List<Entity> getAllEntities(){
			List<Entity> all = new ArrayList<Entity>(getNonPartyNpcs());
			all.addAll(getPartyNpcs());
			all.add(getAvatar());
			return all;
	}
	
	public static void update() {
		for(Entity e : getAllEntities()){
			e.update();
		}
	}
	/**
	 * Returns null in the event an entity isn't found at given location
	 * @param location
	 * @return
	 */
	public static Entity getEntityAtLocation(RealCoordinate location) {
		for(Entity e : getAllEntities()){
			if(location.equals(e.getLocation())){
				return e;
			}
		}
		return null;
	}
	
	public static void addPartyNpc(NPC npc) {
		EntityManager.partyNpcs.add(npc);
	}

	public static ArrayList<NPC> getPartyNpcs() {
		return partyNpcs;
	}

	public static void setPartyNpcs(ArrayList<NPC> partyNpcs) {
		EntityManager.partyNpcs = partyNpcs;
	}

	public static ArrayList<NPC> getNonPartyNpcs() {
		return nonPartyNpcs;
	}

	public static void setNonPartyNpcs(ArrayList<NPC> nonPartyNpcs) {
		EntityManager.nonPartyNpcs = nonPartyNpcs;
	}

	public static Avatar getAvatar() {
		return avatar;
	}

	public static void setAvatar(Avatar avatar) {
		EntityManager.avatar = avatar;
	}

}
