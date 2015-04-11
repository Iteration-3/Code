package model.entity.behavior.npc.interact;

import model.entity.Entity;

public class Barter implements InteractableBehaviorState{
	private Entity barter;
	
	public Barter(Entity entity){
		this.barter = entity;
	}

	public void interact(Entity entity) {
		//barter stuff
	}

}
