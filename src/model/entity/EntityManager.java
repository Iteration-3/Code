package model.entity;

import java.util.ArrayList;

public class EntityManager {
	private ArrayList<NPC> partyNPCList_ = null;
	//Entities "allied" with player, vs those that aren't
	private Arraylist<NPC> nonPartyNPCList_ = null;
	private Avatar avatar_ = null;
	
	/**
	 * Keep all entities updated
	 */
	public void update(){
		for(NPC : partyNPCList_){
			NPC.update();
		}
		for(NPC : nonPartyNPCList_){
			NPC.update();
		}
		avatar_.update();
	}

	/**
	 * Adds an NPC to the party list
	 * @param npc
	 */
	public void addPartyNPC(NPC npc){
		partyNPCList_.add(npc);
	}
	/**
	 * Adds an NPC to the nonparty list
	 * @param npc
	 */
	public void addNonPartyNPC(NPC npc){
		nonPartyNPCList_.add(npc);
	}
	/**
	 * NOT YET IMPLEMENETED
	 * @param loc
	 * @return
	 */
	public Entity getEntityAtlocation(Location loc){
		return null;
	}
	/**
	 * NOT YET IMPLEMENTED
	 * @param map
	 */
	public void load(StructuredMap map){
		
	}
	/**
	 * NOT YET IMPLEMENTED
	 * @return
	 */
	public StructuredMap save(){
		return null;
	}
}
