package model.entity.behavior.npc.defaultb.circuit;

import utilities.Direction;

public interface Circuitable {
	
	public Direction nextMove();
	
	public boolean hasMove();

}
