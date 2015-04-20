package model.entity.behavior.npc.defaultb;

import model.entity.Entity;

public class Stand implements DefaultableBehaviorState {
	private Entity chosenOne;
	
	public Stand(Entity entity){
		this.chosenOne = entity;
	}

	@Override
	public void perform() {
		//stand here, yep
	}

}
