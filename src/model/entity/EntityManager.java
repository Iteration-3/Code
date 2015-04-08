package model.entity;

import java.util.ArrayList;

public class EntityManager {
	private ArrayList<NPC> partyNPCList_ = null;
	//Entities "allied" with player, vs those that aren't
	private Arraylist<NPC> nonPartyNPCList_ = null;
	private Avatar avetar_ = null;
	
	//Keep all entities updated
	public void update(){
		for(NPC : partyNPCList_){
			NPC.update();
		}
		for(NPC : nonPartyNPCList_){
			NPC.update();
		}
		avatar_.update();
	}
	
	public void addPartyNPC(NPC npc){
		partyNPCList_.add(npc);
	}
	
	public void addNonPartyNPC(NPC npc){
		nonPartyNPCList_.add(npc);
	}
	
	public Entity getEntityAtlocation(Location loc){
		return null;
	}
	
	public void load(StructuredMap map){
		
	}
	public StructuredMap save(){
		return null;
	}
}
