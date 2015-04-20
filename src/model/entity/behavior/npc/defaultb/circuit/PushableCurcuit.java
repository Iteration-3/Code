package model.entity.behavior.npc.defaultb.circuit;

import java.util.LinkedList;
import java.util.Queue;

import utilities.Angle;

public class PushableCurcuit implements Circuitable{
	Queue<Angle> moves = new LinkedList<Angle>();
	
	public PushableCurcuit(){
		
	}
	
	public void push(Angle move){
		this.moves.add(move);
	}

	@Override
	public Angle nextMove() {
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
