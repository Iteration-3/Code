package model.entity.behavior.npc.defaultb;

import model.entity.Entity;
import model.entity.behavior.npc.defaultb.circuit.PushableCurcuit;
import utilities.Direction;

public class ListenForMovement implements DefaultableBehaviorState {
	private Entity chosenOne;
	private PushableCurcuit curcuit = new PushableCurcuit();

	public ListenForMovement(Entity entity){
		this.chosenOne = entity;
	}

	@Override
	public void perform() {
		//as of now it will stand, and wait for a movment from the Behavior,
		// these movements will be sent from the Observable State
		if (this.curcuit.hasMove()){
			this.chosenOne.move(this.curcuit.nextMove());
		}
	}
	
	public void push(Direction move){
		if (move == null){
			return;
		}
		this.curcuit.push(move);
	}
}
