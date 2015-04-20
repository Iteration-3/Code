package model.entity.behavior.npc.defaultb.circuit;

import java.util.LinkedList;
import java.util.Queue;

import utilities.Direction;

public class PushableCurcuit implements Circuitable{
	Queue<Direction> moves = new LinkedList<Direction>();
	
	public PushableCurcuit(){
		
	}
	
	public void push(Direction move){
		this.moves.add(move);
	}

	@Override
	public Direction nextMove() {
		if(moves.isEmpty()){
			return null;
		}
		else{
			return this.moves.remove();
		}
	}

	@Override
	public boolean hasMove() {
		return !this.moves.isEmpty();
	}


}
