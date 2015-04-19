package model.entity.behavior.npc.defaultb;

import utilities.Angle;
import model.entity.Entity;
import model.entity.behavior.npc.defaultb.curcuit.PushableCurcuit;

public class Pursue implements DefaultableBehaviorState {
	private Entity chosenOne;
	private PushableCurcuit curcuit = new PushableCurcuit();

	public Pursue(Entity entity){
		this.chosenOne = entity;
	}

	public void perform() {
		//as of now it will stand, and wait for a movment from the Behavior,
		// these movements will be sent from the Observable State
		if (this.curcuit.hasMove()){
			this.chosenOne.move(this.curcuit.nextMove());
			System.out.println(this.chosenOne.toString());
		}
	}
	
	public void push(Angle move){
		if (move == null){
			return;
		}
		this.curcuit.push(move);
	}
	
	

}
