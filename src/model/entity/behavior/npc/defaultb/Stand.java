package model.entity.behavior.npc.defaultb;

import model.entity.Entity;

public class Stand implements DefaultBehaviorState {
	private Entity chosenOne;
	
	public Stand(Entity entity){
		this.chosenOne = entity;
	}

	public void perform() {
		//stand here, yep
	}

}
