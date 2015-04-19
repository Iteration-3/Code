package model.entity.behavior.npc.defaultb;

import java.util.LinkedList;
import java.util.Queue;

import utilities.Angle;
import model.area.RealCoordinate;
import model.entity.Entity;

public class Coward implements DefaultableBehaviorState {
	private Queue<Angle> nextMove = new LinkedList<Angle>();
	private Entity chosenOne;
	
	// this will receive information from the Observe that is given to the Entity

	public Coward(Entity entity) {
		this.chosenOne = entity;
	}

	public void perform() {
		this.move();
	}

	private void move() {
		boolean isNotEmpty = !this.nextMove.isEmpty();
		if (isNotEmpty) {
			Angle moveTo = this.nextMove.poll();
			this.chosenOne.move(moveTo);
		}
	}

	public void setNextMove(Angle loc) {
		this.nextMove.add(loc);
	}

}
