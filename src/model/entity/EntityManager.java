package model.entity;

import java.util.ArrayList;

import model.area.Location;

public class EntityManager {
	private static ArrayList<NPC> partyNpcs;
	private static ArrayList<NPC> nonPartyNpcs;
	private static Avatar avatar;
	
	public static void update() {
		// TODO(jraviles)
	}
	
	public Entity getEntityAtLocation(Location location) {
		// TODO(jraviles)
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
