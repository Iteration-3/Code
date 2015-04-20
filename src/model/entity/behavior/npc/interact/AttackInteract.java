package model.entity.behavior.npc.interact;

import model.entity.Avatar;
import model.entity.Entity;
import model.entity.NPC;

public class AttackInteract implements InteractableBehaviorState {

	public void accept(NPC entity) {

	}

	public void accept(Avatar avatar) {
		
	}

	public void interact(Entity entity) {
		entity.accept(this);
	}

}
