package gameactions;

import utilities.Angle;
import model.entity.Entity;

public class GameActionMovementUpRight extends GameActionMovement{

	GameActionMovementUpRight(Entity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void perform() {
		this.getEntity().move(Angle.UP_RIGHT);
		
	}

}
