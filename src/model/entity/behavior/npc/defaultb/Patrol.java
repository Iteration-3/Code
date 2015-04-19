package model.entity.behavior.npc.defaultb;

import model.entity.Entity;
import model.entity.behavior.npc.defaultb.curcuit.UpDown;

public class Patrol implements DefaultableBehaviorState {
	private Entity chosenOne;
	private UpDown curcit;
	
	public Patrol(Entity entity){
		this.chosenOne = entity;
		this.curcit = new UpDown();
	}
	
	public void perform(){
		this.chosenOne.move(this.curcit.nextMove());
	}

}
