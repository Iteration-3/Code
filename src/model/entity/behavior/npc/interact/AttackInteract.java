package model.entity.behavior.npc.interact;

import model.entity.Avatar;
import model.entity.Entity;
import model.entity.NPC;
import model.event.EventManager;
import model.event.HealthModifierEvent;

public class AttackInteract implements InteractableBehaviorState {
	private Entity chosen;
	
	public AttackInteract(Entity entity){
		this.chosen = entity;
	}

	public void accept(NPC entity) {

	}

	public void accept(Avatar avatar) {
		//TODO  damage needs to be modified with skill points
		int damage = this.chosen.getDamage() * -1;
		this.chosen.attackEntity(avatar,damage);
	}

	public void interact(Entity entity) {
		entity.accept(this);
	}

}
