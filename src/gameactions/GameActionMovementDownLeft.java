package gameactions;

import utilities.Angle;
import model.entity.Entity;

public class GameActionMovementDownLeft extends GameActionMovement {

	GameActionMovementDownLeft(Entity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void perform() {
		this.getEntity().move(Angle.DOWN_LEFT);
		
	}
}
