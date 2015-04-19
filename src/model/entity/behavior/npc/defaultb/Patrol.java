package model.entity.behavior.npc.defaultb;

import model.entity.Entity;
import model.entity.behavior.npc.defaultb.curcuit.Curcuitable;
import model.entity.behavior.npc.defaultb.curcuit.UpDown;

public class Patrol implements DefaultableBehaviorState {
	private Entity chosenOne;
	private Curcuitable curcit;
	
	public Patrol(Entity entity, Curcuitable curcuit){
		this.chosenOne = entity;
		this.curcit = curcuit;
	}
	
	public void perform(){
		this.chosenOne.move(this.curcit.nextMove());
	}

}
