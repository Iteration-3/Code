package model.entity.behavior.npc.defaultb;

import model.entity.Entity;
import model.entity.behavior.npc.defaultb.circuit.Circuitable;

public class Patrol implements DefaultableBehaviorState {
	private Entity chosenOne;
	private Circuitable curcit;
	
	public Patrol(Entity entity, Circuitable curcuit){
		this.chosenOne = entity;
		this.curcit = curcuit;
	}
	
	public void perform(){
		this.chosenOne.move(this.curcit.nextMove());
	}

}
