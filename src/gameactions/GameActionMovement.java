package gameactions;

import model.entity.Entity;

public abstract class GameActionMovement extends GameAction {
	private Entity entity;

	public GameActionMovement(Entity entity){
		this.entity = entity;
	}

	protected Entity getEntity(){
		return entity;
	}
}
