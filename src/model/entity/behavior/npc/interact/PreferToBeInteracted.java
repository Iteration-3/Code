package model.entity.behavior.npc.interact;

import model.entity.Avatar;
import model.entity.Entity;
import model.entity.NPC;

public class PreferToBeInteracted implements InteractableBehaviorState {
	private Entity chosen;
	
	public PreferToBeInteracted(Entity entity){
		this.chosen = entity;
	}

	public void accept(NPC entity) {
	}

	public void accept(Avatar avatar) {
	}

	public void interact(Entity entity) {
		entity.interact(this.chosen);
	}

}
