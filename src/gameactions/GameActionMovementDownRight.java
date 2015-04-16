package gameactions;

import utilities.Angle;
import model.entity.Entity;

public class GameActionMovementDownRight extends GameActionMovement{

	public GameActionMovementDownRight(Entity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void perform() {
		this.getEntity().move(Angle.DOWN_RIGHT);
		
	}

}
