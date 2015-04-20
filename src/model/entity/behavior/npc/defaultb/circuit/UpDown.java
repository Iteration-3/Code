package model.entity.behavior.npc.defaultb.circuit;

import java.util.Deque;
import java.util.LinkedList;

import utilities.Direction;

public class UpDown implements Circuitable{
	Deque<Direction> moves = new LinkedList<Direction>();
	public UpDown(){
		this.setMoves();
	}
	
	public void setMoves() {
		moves.push(Direction.UP);
		moves.push(Direction.UP);
		moves.push(Direction.UP);
		moves.push(Direction.DOWN);
		moves.push(Direction.DOWN);
		moves.push(Direction.DOWN);
	}
	
	@Override
	public Direction nextMove() {
		Direction move = moves.removeFirst();
		moves.addFirst(move);
		return move;
	}

	@Override
	public boolean hasMove() {
		return true;
	}
	

}
