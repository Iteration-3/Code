package model.entity.behavior.npc.interact;

import model.entity.Avatar;
import model.entity.Entity;
import model.entity.NPC;

public class AttackInteract implements InteractableBehaviorState {
	private Entity chosen;
	private boolean attackEntity;
	
	public AttackInteract(Entity entity){
		this.chosen = entity;
	}
	public AttackInteract(Entity entity,boolean attackEntity ){
		this.chosen = entity;
		this.attackEntity = attackEntity;
	}

	@Override
	public void accept(NPC entity) {
		if (attackEntity){
			//TODO  damage needs to be modified with skill points
			this.chosen.attackEntity(entity,30);
		}

	}

	@Override
	public void accept(Avatar avatar) {
		//TODO  damage needs to be modified with skill points
		int damage = this.chosen.getDamage() * -1;
		this.chosen.attackEntity(avatar,damage);
	}

	@Override
	public void interact(Entity entity) {
		entity.accept(this);
	}

}
