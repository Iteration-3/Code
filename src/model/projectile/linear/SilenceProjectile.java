package model.projectile.linear;

import model.area.TileCoordinate;
import model.projectile.Projectile;
import model.trigger.Trigger;
import utilities.Angle;

public class SilenceProjectile extends Projectile {
	
	public SilenceProjectile(TileCoordinate location, Angle direction, Trigger trigger, double speed) {
		super(location, direction, trigger, speed);
	}
}