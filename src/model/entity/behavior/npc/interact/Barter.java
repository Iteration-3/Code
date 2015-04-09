package model.entity.behavior.npc.interact;

import model.entity.Entity;

public class Barter implements InteractBehaviorState{
	private Entity barter;
	
	public Barter(Entity entity){
		this.barter = entity;
	}

	public void interact(Entity entity) {
		//barter stuff
	}

}
