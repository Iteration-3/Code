package model.entity.behavior.npc.defaultb;

import java.util.LinkedList;
import java.util.Queue;

import model.area.RealCoordinate;
import model.entity.Entity;

public class Coward implements DefaultableBehaviorState {
	private Queue<RealCoordinate> nextMove = new LinkedList<RealCoordinate>();
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
			RealCoordinate moveTo = this.nextMove.poll();
		}
	}

	public void setNextMove(RealCoordinate loc) {
		this.nextMove.add(loc);
	}

}
