package gameactions;

import utilities.Angle;
import model.entity.Entity;

public class GameActionMovementDown extends GameActionMovement {

	GameActionMovementDown(Entity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void perform() {
		this.getEntity().move(Angle.DOWN);
		
	}

}
