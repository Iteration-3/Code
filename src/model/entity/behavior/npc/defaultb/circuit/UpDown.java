package model.entity.behavior.npc.defaultb.circuit;

import java.util.Deque;
import java.util.LinkedList;

import utilities.Angle;

public class UpDown implements Circuitable{
	Deque<Angle> moves = new LinkedList<Angle>();
	public UpDown(){
		this.setMoves();
	}
	
	public void setMoves(){
		moves.push(Angle.UP);
		moves.push(Angle.UP);
		moves.push(Angle.UP);
		moves.push(Angle.DOWN);
		moves.push(Angle.DOWN);
		moves.push(Angle.DOWN);
	}
	
	@Override
	public Angle nextMove(){
		Angle move = moves.removeFirst();
		moves.addFirst(move);
		return move;
	}

	@Override
	public boolean hasMove() {
		return true;
	}
	

}
