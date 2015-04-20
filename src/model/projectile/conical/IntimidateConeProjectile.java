package model.projectile.conical;

import model.area.TileCoordinate;
import model.trigger.Trigger;
import utilities.Angle;

public class IntimidateConeProjectile extends ConicalProjectile {

	public IntimidateConeProjectile(TileCoordinate location, Angle direction, Trigger trigger, double speed) {
		super(location, direction, trigger, speed);
	}
}
