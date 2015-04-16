package gameactions;

import utilities.Angle;
import model.entity.Entity;

public class GameActionMovementUpLeft extends GameActionMovement {

	public GameActionMovementUpLeft(Entity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void perform() {
		this.getEntity().move(Angle.UP_LEFT);
		
	}
}
