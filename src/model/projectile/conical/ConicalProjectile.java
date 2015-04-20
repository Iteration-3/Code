package model.projectile.conical;

import model.area.TileCoordinate;
import model.projectile.Projectile;
import model.trigger.Trigger;
import utilities.Angle;

public class ConicalProjectile extends Projectile {

	public ConicalProjectile(TileCoordinate location, Angle direction, Trigger trigger, double speed) {
		super(location, direction, trigger, speed);
	}

	@Override
	public void advance() {
		//TODO
	}

	@Override
	public boolean hasExpired() {
		return getTrigger().hasExpired(); // TODO(jraviles) figure out collisions
	}
}