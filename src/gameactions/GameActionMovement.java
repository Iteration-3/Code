package gameactions;

import utilities.Angle;
import model.entity.Entity;

public class GameActionMovement extends GameAction {
	private Entity entity;
	private Angle direction;

	public GameActionMovement(Entity entity, Angle direction){
		this.entity = entity;
		this.direction = direction;
	}

	@Override
	public void perform() {
		entity.move(direction);
	}
}
